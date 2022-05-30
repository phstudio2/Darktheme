package com.phstudio.darktheme.Fragments

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_changer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val changebtn = view.findViewById<Button>(R.id.changer)
        display()
        changebtn.setOnClickListener {
            changebutton()
        }
    }

    @SuppressLint("ResourceType")
    private fun changebutton() {
        uiModeManager = getSystemService(requireContext(), UiModeManager::class.java)
        if (getDarkMode()) {
            if (Build.VERSION.SDK_INT >= 29) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.systeminsettings),
                    Toast.LENGTH_SHORT
                ).show()
                this.startActivityForResult(Intent(Settings.ACTION_DISPLAY_SETTINGS), 0)
                displaylight()
            }
            if (Build.VERSION.SDK_INT in 23..28) {
                uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_NO
                displaylight()
            }
            if (Build.VERSION.SDK_INT <= 22) {
                val uiManager =
                    requireContext().getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
                uiManager.disableCarMode(DISABLE_CAR_MODE_GO_HOME)
                uiManager.nightMode = UiModeManager.MODE_NIGHT_NO
                displaylight()
            }
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                Toast.makeText(
                    context,
                    resources.getString(R.string.systeminsettings),
                    Toast.LENGTH_SHORT
                ).show()
                this.startActivityForResult(Intent(Settings.ACTION_DISPLAY_SETTINGS), 0)
                displaydark()
            }
            if (Build.VERSION.SDK_INT in 23..28) {
                uiModeManager!!.nightMode = UiModeManager.MODE_NIGHT_YES
                displaydark()
            }
            if (Build.VERSION.SDK_INT <= 22) {
                val uiManager =
                    requireContext().getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
                uiManager.enableCarMode(0)
                uiManager.nightMode = UiModeManager.MODE_NIGHT_YES
                displaydark()
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

    private fun displaydark() {
        val changebtn = view?.findViewById<Button>(R.id.changer)
        val changetext = view?.findViewById<TextView>(R.id.infotext)
        changetext?.text = resources.getString(R.string.dark_mode_active)
        changebtn?.text = resources.getString(R.string.change_to_light_mode)
    }

    private fun displaylight() {
        val changebtn = view?.findViewById<Button>(R.id.changer)
        val changetext = view?.findViewById<TextView>(R.id.infotext)
        changebtn?.text = resources.getString(R.string.change_to_dark_mode)
        changetext?.text = resources.getString(R.string.light_mode_active)
    }

    private fun display() {
        if (getDarkMode()) {
            displaydark()
        } else {
            displaylight()
        }
    }
}