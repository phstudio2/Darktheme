package com.phstudio.darktheme.Fragments

import android.app.AlertDialog
import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R

class WallpaperFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallpaper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonblack = view.findViewById<ImageButton>(R.id.buttonblack)

        buttonblack.setOnClickListener {
            message(R.drawable.black, R.string.amoled)
        }

        val buttonflower = view.findViewById<ImageButton>(R.id.buttonflower)

        buttonflower.setOnClickListener {
            message(R.drawable.flower, R.string.flower)
        }


        val buttonmoon = view.findViewById<ImageButton>(R.id.buttonmoon)

        buttonmoon.setOnClickListener {
            message(R.drawable.moon, R.string.moon)
        }


        val buttoncat = view.findViewById<ImageButton>(R.id.buttoncat)

        buttoncat.setOnClickListener {
            message(R.drawable.cat, R.string.cat)
        }


        val buttonhorse = view.findViewById<ImageButton>(R.id.buttonhorse)

        buttonhorse.setOnClickListener {
            message(R.drawable.horse, R.string.horse)
        }


        val buttondog = view.findViewById<ImageButton>(R.id.buttondog)

        buttondog.setOnClickListener {
            message(R.drawable.dog, R.string.dog)
        }


        val buttonfire = view.findViewById<ImageButton>(R.id.buttonfire)

        buttonfire.setOnClickListener {
            message(R.drawable.fire, R.string.fire)
        }


        val buttongirl = view.findViewById<ImageButton>(R.id.buttongirl)

        buttongirl.setOnClickListener {
            message(R.drawable.girl, R.string.girl)
        }


        val buttonbulb = view.findViewById<ImageButton>(R.id.buttonbulb)

        buttonbulb.setOnClickListener {
            message(R.drawable.bulb, R.string.bulb)
        }

    }

    private fun message(st1: Int, st2: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val dialogBuilder = AlertDialog.Builder(activity)
            dialogBuilder.setIcon(st1)
            dialogBuilder.setMessage(getString(R.string.wantpic))
                .setCancelable(false)
                .setPositiveButton(
                    resources.getString(R.string.Yes)
                ) { _, _ ->
                    val bitmap: Bitmap =
                        BitmapFactory.decodeResource(resources, st1)
                    val wallpaperManager =
                        WallpaperManager.getInstance(requireActivity().baseContext)
                    wallpaperManager.setBitmap(bitmap)
                    Toast.makeText(
                        activity,
                        getString(R.string.starttheme),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                .setNegativeButton(
                    resources.getString(R.string.No)
                ) { dialog, _ ->
                    dialog.cancel()
                }
            val alert = dialogBuilder.create()
            alert.setTitle(getString(st2))
            alert.show()
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.notsupport),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}