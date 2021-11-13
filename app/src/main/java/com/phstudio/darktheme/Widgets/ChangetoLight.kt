package com.phstudio.darktheme.Widgets

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.phstudio.darktheme.R

class ChangetoLight : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        appWidgetIds.forEach { appWidgetId ->
            val pendingIntentDark: PendingIntent =
                Intent(context, LightTheme::class.java).let { intent ->
                    PendingIntent.getActivity(
                        context,
                        0,
                        intent,
                        0
                    )
                }
            val views: RemoteViews =
                RemoteViews(context.packageName, R.layout.changeto_light).apply {
                    setOnClickPendingIntent(R.id.light_button, pendingIntentDark)
                }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}