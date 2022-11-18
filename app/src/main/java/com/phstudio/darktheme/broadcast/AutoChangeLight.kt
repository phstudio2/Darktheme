package com.phstudio.darktheme.broadcast

import android.app.UiModeManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.phstudio.darktheme.R

class AutoChangeLight : BroadcastReceiver() {
    private var uiModeManager: UiModeManager? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        uiModeManager = ContextCompat.getSystemService(context!!, UiModeManager::class.java)
        if (Build.VERSION.SDK_INT >= 29) {
            Toast.makeText(
                context,
                context.resources.getString(R.string.system_in_settings),
                Toast.LENGTH_SHORT
            ).show()

            val intent2 = (Intent(Settings.ACTION_DISPLAY_SETTINGS))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent2)
        }
        if (Build.VERSION.SDK_INT in 23..28) {
            uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_NO
        }
        if (Build.VERSION.SDK_INT <= 22) {
            val uiManager = context.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
            uiManager.disableCarMode(UiModeManager.DISABLE_CAR_MODE_GO_HOME)
            uiManager.nightMode = UiModeManager.MODE_NIGHT_NO
        }
    }
}