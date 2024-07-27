package com.phstudio.darktheme

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.phstudio.darktheme.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT
        setContentView(layout.activity_main)

       val nav = findViewById<BottomNavigationView>(id.bnMain)
        val navController = findNavController(this, id.fcMain)
        nav.setupWithNavController(navController)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val dialogBuilder = AlertDialog.Builder(this@MainActivity)
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
        })
    }
}