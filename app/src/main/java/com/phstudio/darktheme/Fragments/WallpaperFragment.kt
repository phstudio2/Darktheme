package com.phstudio.darktheme.Fragments

import android.app.AlertDialog
import android.app.WallpaperManager
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val buttonselect1 = view.findViewById<Button>(R.id.buttonselect1)


        buttonblack.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.black)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.black)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.amoled))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        buttonselect1.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.black)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.black)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.amoled))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttonflower = view.findViewById<ImageButton>(R.id.buttonflower)
        val buttonselect2 = view.findViewById<Button>(R.id.buttonselect2)

        buttonflower.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.flower)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.flower)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.flower))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.flower)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.flower)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.flower))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttonmoon = view.findViewById<ImageButton>(R.id.buttonmoon)
        val buttonselect3 = view.findViewById<Button>(R.id.buttonselect3)

        buttonmoon.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.moon)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.moon)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.moon))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        buttonselect3.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.moon)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.moon)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.moon))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttoncat = view.findViewById<ImageButton>(R.id.buttoncat)
        val buttonselect4 = view.findViewById<Button>(R.id.buttonselect4)

        buttoncat.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.cat)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.cat)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.cat))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect4.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.cat)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.cat)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.cat))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttonhorse = view.findViewById<ImageButton>(R.id.buttonhorse)
        val buttonselect5 = view.findViewById<Button>(R.id.buttonselect5)

        buttonhorse.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.horse)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.horse)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.horse))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect5.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.horse)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.horse)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.horse))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttondog = view.findViewById<ImageButton>(R.id.buttondog)
        val buttonselect6 = view.findViewById<Button>(R.id.buttonselect6)

        buttondog.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.dog)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.dog)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.dog))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect6.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.dog)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.dog)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.dog))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttonfire = view.findViewById<ImageButton>(R.id.buttonfire)
        val buttonselect7 = view.findViewById<Button>(R.id.buttonselect7)

        buttonfire.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.fire)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.fire)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.fire))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect7.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.fire)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.fire)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.fire))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttongirl = view.findViewById<ImageButton>(R.id.buttongirl)
        val buttonselect8 = view.findViewById<Button>(R.id.buttonselect8)

        buttongirl.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.girl)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.girl)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.girl))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect8.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.girl)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.girl)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.girl))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val buttonbulb = view.findViewById<ImageButton>(R.id.buttonbulb)
        val buttonselect9 = view.findViewById<Button>(R.id.buttonselect9)

        buttonbulb.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.bulb)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.bulb)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.bulb))
                alert.show()
            } else {
                Toast.makeText(
                    context,
                    resources.getString(R.string.notsupport),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        buttonselect9.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val dialogBuilder = AlertDialog.Builder(activity)
                dialogBuilder.setIcon(R.drawable.bulb)
                dialogBuilder.setMessage(getString(R.string.wantpic))
                    .setCancelable(false)
                    .setPositiveButton(
                        resources.getString(R.string.Yes),
                        DialogInterface.OnClickListener { dialog, id ->
                            val bitmap: Bitmap =
                                BitmapFactory.decodeResource(resources, R.drawable.bulb)
                            val wallpaperManager =
                                WallpaperManager.getInstance(requireActivity().baseContext)
                            wallpaperManager.setBitmap(bitmap)
                            Toast.makeText(
                                activity,
                                getString(R.string.starttheme),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        })
                    .setNegativeButton(
                        resources.getString(R.string.No),
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        }
                    )
                val alert = dialogBuilder.create()
                alert.setTitle(getString(R.string.bulb))
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
}