package com.phstudio.darktheme

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.phstudio.darktheme.Fragments.*
import com.phstudio.darktheme.R.*

class MainActivity : AppCompatActivity() {

    private val ChangerFragment = ChangerFragment()
    private val FilterFragment = FilterFragment()
    private val WallpaperFragment = WallpaperFragment()
    private val SchedulerFragment = SchedulerFragment()
    private val SettingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        replaceFragment(ChangerFragment)
        val bottom_navigation = findViewById<BottomNavigationView>(id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                id.it_changer -> replaceFragment(ChangerFragment)
                id.it_filters -> replaceFragment(FilterFragment)
                id.it_wallpapers -> replaceFragment(WallpaperFragment)
                id.it_scheduler -> replaceFragment(SchedulerFragment)
                id.it_settings -> replaceFragment(SettingsFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transtction = supportFragmentManager.beginTransaction()
        transtction.replace(id.fragment_container, fragment)
        transtction.commit()
    }

    override fun onBackPressed() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setIcon(mipmap.ic_launcher_round)
        dialogBuilder.setMessage(resources.getString(string.close_app))
            .setCancelable(false)
            .setPositiveButton(
                resources.getString(string.Yes)
            ) { _, _ ->
                finishAffinity()
            }
            .setNegativeButton(
                resources.getString(string.No)
            ) { dialog, _ ->
                dialog.cancel()
            }
        val alert = dialogBuilder.create()
        alert.setTitle(resources.getString(string.Exit_app))
        alert.show()
    }
}