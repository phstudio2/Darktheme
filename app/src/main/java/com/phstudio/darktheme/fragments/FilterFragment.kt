package com.phstudio.darktheme.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
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
        val tgbFilters = view.findViewById<ToggleButton>(R.id.tgbFilters)
        val btReset = view.findViewById<Button>(R.id.btReset)

        val seek = view.findViewById<SeekBar>(R.id.sbSun)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                //onProgressChanged
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                //onStartTrackingTouch
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val intValue = ((seek.progress) * 2.55).toInt()
                tgbFilters.isChecked = true
                editor.putInt("color0", intValue).apply()
                editor.putInt("color", 0).apply()
                startView()
            }
        })

        val seek2 = view.findViewById<SeekBar>(R.id.sbLight)
        seek2?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                //onProgressChanged
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                //onStartTrackingTouch
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val intValue = ((seek.progress) * 2.55).toInt()
                tgbFilters.isChecked = true
                editor.putInt("color1", intValue).apply()
                editor.putInt("color", 1).apply()
                startView()
            }
        })

        val seek3 = view.findViewById<SeekBar>(R.id.sbMoon)
        seek3?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                //onProgressChanged
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                //onStartTrackingTouch
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                val intValue = ((seek.progress) * 2.55).toInt()
                tgbFilters.isChecked = true
                editor.putInt("color2", intValue).apply()
                editor.putInt("color", 2).apply()
                startView()
            }
        })

        val color0 = sharedPreferences.getInt("color0", 50)
        val color1 = sharedPreferences.getInt("color1", 30)
        val color2 = sharedPreferences.getInt("color2", 80)

        seek.progress = (color0 / 2.55).toInt()
        seek2.progress = (color1 / 2.55).toInt()
        seek3.progress = (color2 / 2.55).toInt()

        tgbFilters.apply {
            isChecked = OverlayService.isActive
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        OverlayService.start(context)
                    } else {
                        Toast.makeText(
                            context,
                            resources.getString(R.string.not_support),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                        OverlayService.stop(context)
                    } else {
                        Toast.makeText(
                            context,
                            resources.getString(R.string.not_support),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        btReset.setOnClickListener {
            tgbFilters.isChecked = false

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                OverlayService.stop(requireContext())
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.not_support),
                    Toast.LENGTH_SHORT
                ).show()
            }

            editor.putInt("color0", 50).apply()
            editor.putInt("color", 0).apply()

            editor.putInt("color1", 30).apply()
            editor.putInt("color", 1).apply()

            editor.putInt("color2", 80).apply()
            editor.putInt("color", 2).apply()

            val color0Reset = sharedPreferences.getInt("color0", 50)
            val color1Reset = sharedPreferences.getInt("color1", 30)
            val color2Reset = sharedPreferences.getInt("color2", 80)

            seek.progress = (color0Reset / 2.55).toInt()
            seek2.progress = (color1Reset / 2.55).toInt()
            seek3.progress = (color2Reset / 2.55).toInt()
        }
    }

    private fun startView() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            context?.let { OverlayService.start(it) }
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.not_support),
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    @Suppress("DEPRECATION")
    private fun requestOverlayPermission() {
        if (isOverlayGranted()) return
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + resources.getString(R.string.app_package))
        )
        startActivityForResult(intent, OVERLAY_PERMISSION_REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
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
