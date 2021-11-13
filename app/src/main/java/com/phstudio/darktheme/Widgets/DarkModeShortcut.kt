package com.phstudio.darktheme.Widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.phstudio.darktheme.MainActivity
import com.phstudio.darktheme.R

class DarkModeShortcut : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        appWidgetIds.forEach { appWidgetId ->
            val pendingIntent: PendingIntent =
                Intent(context, MainActivity::class.java).let { intent ->
                    PendingIntent.getActivity(
                        context,
                        0,
                        intent,
                        0
                    )
                }
            val views: RemoteViews =
                RemoteViews(context.packageName, R.layout.dark_mode_shortcut).apply {
                    setOnClickPendingIntent(R.id.app_button, pendingIntent)
                }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}