package com.phstudio.darktheme.Fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R

class FilterFragment : Fragment() {

    companion object {
        private const val OVERLAY_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestOverlayPermission()
        val sharedPreferences = this.requireActivity()
            .getSharedPreferences(resources.getString(R.string.app_package), Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val color = sharedPreferences.getInt("color", 0)

        val imageView1 = view.findViewById<ImageButton>(R.id.imageView1)
        val imageView2 = view.findViewById<ImageButton>(R.id.imageView2)
        val imageView3 = view.findViewById<ImageButton>(R.id.imageView3)

        when (color) {
            1 -> {
                imageView1.setBackgroundResource(R.drawable.layout_selected)
                imageView2.setBackgroundResource(R.drawable.layout_select)
                imageView3.setBackgroundResource(R.drawable.layout_select)
            }
            2 -> {
                imageView1.setBackgroundResource(R.drawable.layout_select)
                imageView2.setBackgroundResource(R.drawable.layout_selected)
                imageView3.setBackgroundResource(R.drawable.layout_select)
            }
            else -> {
                imageView1.setBackgroundResource(R.drawable.layout_select)
                imageView2.setBackgroundResource(R.drawable.layout_select)
                imageView3.setBackgroundResource(R.drawable.layout_selected)
            }
        }

        val infotext = view.findViewById<ToggleButton>(R.id.infotext)
        infotext.apply {
            isChecked = OverlayService.isActive
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        OverlayService.start(context)
                    } else {
                        Toast.makeText(
                            context,
                            resources.getString(R.string.notsupport),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        OverlayService.stop(context)
                    } else {
                        Toast.makeText(
                            context,
                            resources.getString(R.string.notsupport),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        imageView1.setOnClickListener {
            editor.putInt("color", 1).apply()
            imageView1.setBackgroundResource(R.drawable.layout_selected)
            imageView2.setBackgroundResource(R.drawable.layout_select)
            imageView3.setBackgroundResource(R.drawable.layout_select)
        }

        imageView2.setOnClickListener {
            editor.putInt("color", 2).apply()
            imageView1.setBackgroundResource(R.drawable.layout_select)
            imageView2.setBackgroundResource(R.drawable.layout_selected)
            imageView3.setBackgroundResource(R.drawable.layout_select)
        }

        imageView3.setOnClickListener {
            editor.putInt("color", 0).apply()
            imageView1.setBackgroundResource(R.drawable.layout_select)
            imageView2.setBackgroundResource(R.drawable.layout_select)
            imageView3.setBackgroundResource(R.drawable.layout_selected)
        }

    }


    fun requestOverlayPermission() {
        if (isOverlayGranted()) return
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + resources.getString(R.string.app_package))
        )
        startActivityForResult(intent, OVERLAY_PERMISSION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQUEST_CODE) {
            if (!isOverlayGranted()) {
                requireActivity().finish()
            }
        }
    }

    private fun isOverlayGranted() =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.canDrawOverlays(context)
}
