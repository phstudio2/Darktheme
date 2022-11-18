package com.phstudio.darktheme.tiles

import android.app.UiModeManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.service.quicksettings.TileService
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.phstudio.darktheme.R


@RequiresApi(Build.VERSION_CODES.N)
class TileMoon : TileService() {

    private var uiModeManager: UiModeManager? = null

    override fun onClick() {
        super.onClick()
        uiModeManager = ContextCompat.getSystemService(this, UiModeManager::class.java)
        if (Build.VERSION.SDK_INT >= 29) {
            Toast.makeText(this, resources.getString(R.string.system_in_settings), Toast.LENGTH_SHORT)
                .show()
            val intent = (Intent(Settings.ACTION_DISPLAY_SETTINGS))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            applicationContext.startActivity(intent)
        }
        if (Build.VERSION.SDK_INT in 23..28) {
            uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_YES
        }
        if (Build.VERSION.SDK_INT <= 22) {
            val uiManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
            uiManager.enableCarMode(0)
            uiManager.nightMode = UiModeManager.MODE_NIGHT_YES
        }
    }
}