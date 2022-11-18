package com.phstudio.darktheme.fragments

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.phstudio.darktheme.R
import com.phstudio.darktheme.broadcast.NotificationBroadcast


object MyNotification {


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("NewApi")
    fun build(context: Context): Notification {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(
            NotificationChannel(
                context.getString(R.string.CHANNEL_ID),
                context.getString(R.string.CHANNEL_NAME),
                NotificationManager.IMPORTANCE_DEFAULT
            )
        )
        val flags = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE
            else -> FLAG_UPDATE_CURRENT
        }
        val intent = Intent(context, NotificationBroadcast::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(context, 0, intent, flags)
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