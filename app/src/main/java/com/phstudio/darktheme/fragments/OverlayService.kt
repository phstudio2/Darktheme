package com.phstudio.darktheme.fragments

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class OverlayService : Service() {
    companion object {
        private const val ACTION_SHOW = "SHOW"
        private const val ACTION_HIDE = "HIDE"

        fun start(context: Context) {
            val intent = Intent(context, OverlayService::class.java).apply {
                action = ACTION_SHOW
            }
            context.startService(intent)
        }

        fun stop(context: Context) {
            val intent = Intent(context, OverlayService::class.java).apply {
                action = ACTION_HIDE
            }
            context.startService(intent)
        }

        var isActive = false
            private set
    }

    private lateinit var overlayView: OverlayView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate() {
        val notification = MyNotification.build(this)
        startForeground(1, notification)
        overlayView = OverlayView.onCreate(this)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_SHOW -> {
                    isActive = true
                    overlayView.show()
                }
                ACTION_HIDE -> {
                    isActive = false
                    overlayView.hide()
                    stopSelf()
                }
                else -> Toast.makeText(
                    applicationContext,
                    "Need action property to start ${OverlayService::class.java.simpleName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() = overlayView.hide()
    override fun onBind(intent: Intent?): Nothing? = null
}
