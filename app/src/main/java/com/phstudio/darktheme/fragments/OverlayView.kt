package com.phstudio.darktheme.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import com.phstudio.darktheme.R

class OverlayView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : FrameLayout(ctx, attrs, defStyle) {
    companion object {
        fun onCreate(context: Context) =
            View.inflate(context, R.layout.overlay_view, null) as OverlayView
    }

    private val windowManager: WindowManager =
        ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    private val layoutParams = WindowManager.LayoutParams(
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        PixelFormat.TRANSLUCENT
    )

    @SuppressLint("ResourceAsColor")
    @Synchronized
    fun show() {
        val sharedPreferences =
            context.getSharedPreferences(
                resources.getString(R.string.app_package),
                Context.MODE_PRIVATE
            )
        val color = sharedPreferences.getInt("color", 0)
        val vOverlayView = findViewById<FrameLayout>(R.id.vOverlayView)

        when (color) {
            1 -> {
                val color1 = sharedPreferences.getInt("color1", 30)
                vOverlayView.setBackgroundColor(
                    Color.argb(color1, 255, 213, 0)
                )
            }
            2 -> {
                val color2 = sharedPreferences.getInt("color2", 80)
                vOverlayView.setBackgroundColor(
                    Color.argb(color2, 0, 0, 0)
                )
            }
            else -> {
                val color0 = sharedPreferences.getInt("color0", 50)
                vOverlayView.setBackgroundColor(
                    Color.argb(color0, 255, 255, 255)
                )
            }
        }

        if (!this.isShown) {
            windowManager.addView(this, layoutParams)
        }
    }

    @Synchronized
    fun hide() {
        if (this.isShown) {
            windowManager.removeView(this)
        }
    }
}
