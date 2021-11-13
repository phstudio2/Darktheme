package com.phstudio.darktheme.Widgets

import android.app.UiModeManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.phstudio.darktheme.R

class LightTheme : AppCompatActivity() {

    private var uiModeManager: UiModeManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_light)
        uiModeManager = ContextCompat.getSystemService(this, UiModeManager::class.java)
        if (Build.VERSION.SDK_INT >= 29) {
            Toast.makeText(this, resources.getString(R.string.systeminsettings), Toast.LENGTH_SHORT)
                .show()
            val intent = (Intent(Settings.ACTION_DISPLAY_SETTINGS))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            applicationContext.startActivity(intent)
        }
        if (Build.VERSION.SDK_INT in 23..28) {
            uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_NO
        }
        if (Build.VERSION.SDK_INT <= 22) {
            val uiManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
            uiManager.disableCarMode(UiModeManager.DISABLE_CAR_MODE_GO_HOME)
            uiManager.nightMode = UiModeManager.MODE_NIGHT_NO
        }
        finishAffinity()
    }
}