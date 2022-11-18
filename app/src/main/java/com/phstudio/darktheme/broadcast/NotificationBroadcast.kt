package com.phstudio.darktheme.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val pm = context.packageManager
        val intent1 = pm.getLaunchIntentForPackage(context.packageName)
        val mainIntent = Intent.makeRestartActivityTask(intent1!!.component)
        context.startActivity(mainIntent)
        Runtime.getRuntime().exit(0)
    }
}