package com.phstudio.darktheme.Fragments

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.phstudio.darktheme.MainActivity
import com.phstudio.darktheme.R
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton


object MyNotification {

    private const val CHANNEL_IMPORTANCE = NotificationManager.IMPORTANCE_DEFAULT
    private val ACTIVITY = MainActivity::class.java

    @SuppressLint("NewApi")
    fun build(context: Context): Notification {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(
            NotificationChannel(
                context.getString(R.string.CHANNEL_ID),
                context.getString(R.string.CHANNEL_NAME),
                CHANNEL_IMPORTANCE
            )
        )
        val pendingIntent = PendingIntent.getActivity(
            context, 0, Intent(context, ACTIVITY), 0
        )
        return Notification.Builder(context, context.getString(R.string.CHANNEL_ID))
            .setAutoCancel(false)
            .setContentIntent(pendingIntent)
            .setContentTitle(context.getText(R.string.text_filters))
            .setContentText(context.getText(R.string.ContentText))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setTicker(context.getText(R.string.app_name))
            .setWhen(System.currentTimeMillis())
            .build()
    }
}
