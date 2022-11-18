package com.phstudio.darktheme.widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import com.phstudio.darktheme.R

class ChangeToDark : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        appWidgetIds.forEach { appWidgetId ->
            val flags = when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                else -> PendingIntent.FLAG_UPDATE_CURRENT
            }
            val pendingIntentDark: PendingIntent =
                Intent(context, DarkTheme::class.java).let { intent ->
                    PendingIntent.getActivity(
                        context,
                        0,
                        intent,
                        flags
                    )
                }
            val views: RemoteViews =
                RemoteViews(context.packageName, R.layout.change_to_dark).apply {
                    setOnClickPendingIntent(R.id.btDark, pendingIntentDark)
                }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}