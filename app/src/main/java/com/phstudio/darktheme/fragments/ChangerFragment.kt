package com.phstudio.darktheme.fragments

import android.annotation.SuppressLint
import android.app.UiModeManager
import android.app.UiModeManager.DISABLE_CAR_MODE_GO_HOME
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R

class ChangerFragment : Fragment() {

    private var uiModeManager: UiModeManager? = null
    private lateinit var btChanger: Button
    private lateinit var tvMode: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_changer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiModeManager = getSystemService(requireContext(), UiModeManager::class.java)
        btChanger = view.findViewById(R.id.btChanger)
        tvMode = view.findViewById(R.id.tvMode)
        display()
        btChanger.setOnClickListener {
            changeButton()
        }
    }

    @Suppress("DEPRECATION")
    @SuppressLint("ResourceType")
    private fun changeButton() {
        if (getDarkMode()) {
            if (Build.VERSION.SDK_INT >= 29) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.system_in_settings),
                    Toast.LENGTH_SHORT
                ).show()
                this.startActivityForResult(Intent(Settings.ACTION_DISPLAY_SETTINGS), 0)
                displayLight()
            }
            if (Build.VERSION.SDK_INT in 23..28) {
                uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_NO
                displayLight()
            }
            if (Build.VERSION.SDK_INT <= 22) {
                val uiManager =
                    requireContext().getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
                uiManager.disableCarMode(DISABLE_CAR_MODE_GO_HOME)
                uiManager.nightMode = UiModeManager.MODE_NIGHT_NO
                displayLight()
            }
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.system_in_settings),
                    Toast.LENGTH_SHORT
                ).show()
                this.startActivityForResult(Intent(Settings.ACTION_DISPLAY_SETTINGS), 0)
                displayDark()
            }
            if (Build.VERSION.SDK_INT in 23..28) {
                uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_YES
                displayDark()
            }
            if (Build.VERSION.SDK_INT <= 22) {
                val uiManager =
                    requireContext().getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
                uiManager.enableCarMode(0)
                uiManager.nightMode = UiModeManager.MODE_NIGHT_YES
                displayDark()
            }
        }
    }

    private fun getDarkMode(): Boolean {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_NO -> {
                return false
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                return true
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                return false
            }
        }
        return false
    }

    private fun displayDark() {
        tvMode.text = resources.getString(R.string.dark_mode_active)
        btChanger.text = resources.getString(R.string.change_to_light_mode)
    }

    private fun displayLight() {
        btChanger.text = resources.getString(R.string.change_to_dark_mode)
        tvMode.text = resources.getString(R.string.light_mode_active)
    }

    private fun display() {
        if (getDarkMode()) {
            displayDark()
        } else {
            displayLight()
        }
    }
}