package com.phstudio.darktheme.fragments

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
        val ibBlack = view.findViewById<ImageButton>(R.id.ibBlack)

        ibBlack.setOnClickListener {
            toastDialog(R.drawable.black, R.string.amoled)
        }

        val ibFlower = view.findViewById<ImageButton>(R.id.ibFlower)

        ibFlower.setOnClickListener {
            toastDialog(R.drawable.flower, R.string.flower)
        }


        val ibMoon = view.findViewById<ImageButton>(R.id.ibMoon)

        ibMoon.setOnClickListener {
            toastDialog(R.drawable.moon, R.string.moon)
        }


        val ibCat = view.findViewById<ImageButton>(R.id.ibCat)

        ibCat.setOnClickListener {
            toastDialog(R.drawable.cat, R.string.cat)
        }


        val ibHorse = view.findViewById<ImageButton>(R.id.ibHorse)

        ibHorse.setOnClickListener {
            toastDialog(R.drawable.horse, R.string.horse)
        }


        val ibDog = view.findViewById<ImageButton>(R.id.ibDog)

        ibDog.setOnClickListener {
            toastDialog(R.drawable.dog, R.string.dog)
        }


        val ibFire = view.findViewById<ImageButton>(R.id.ibFire)

        ibFire.setOnClickListener {
            toastDialog(R.drawable.fire, R.string.fire)
        }


        val ibGirl = view.findViewById<ImageButton>(R.id.ibGirl)

        ibGirl.setOnClickListener {
            toastDialog(R.drawable.girl, R.string.girl)
        }


        val ibBulb = view.findViewById<ImageButton>(R.id.ibBulb)

        ibBulb.setOnClickListener {
            toastDialog(R.drawable.bulb, R.string.bulb)
        }

    }

    private fun toastDialog(st1: Int, st2: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val dialogBuilder = AlertDialog.Builder(activity)
            dialogBuilder.setIcon(st1)
            dialogBuilder.setMessage(getString(R.string.want_pic))
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
                        getString(R.string.start_theme),
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
                resources.getString(R.string.not_support),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}