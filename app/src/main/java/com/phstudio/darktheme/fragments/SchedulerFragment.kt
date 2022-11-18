package com.phstudio.darktheme.fragments

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent.*
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
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
import com.phstudio.darktheme.broadcast.AutoChangeDark
import com.phstudio.darktheme.broadcast.AutoChangeLight
import java.text.SimpleDateFormat
import java.util.*

class SchedulerFragment : Fragment() {

    private lateinit var alarmManager: AlarmManager
    private var flags: Int = FLAG_UPDATE_CURRENT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scheduler, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val btTimeDark = view.findViewById<Button>(R.id.btTimeDark)
        val btTimeLight = view.findViewById<Button>(R.id.btTimeLight)
        val ibTimeDark = view.findViewById<ImageButton>(R.id.ibTimeDark)
        val ibTimeLight = view.findViewById<ImageButton>(R.id.ibTimeLight)

        var time: Long

        val sharedPreferences = requireActivity().getSharedPreferences(
            resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        )
        val editor = requireActivity().getSharedPreferences(
            resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        flags = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE
            else -> FLAG_UPDATE_CURRENT
        }

        val darkText = sharedPreferences.getString("DarkText", "")
        val lightText = sharedPreferences.getString("LightText", "")

        val darkHistory = sharedPreferences.getBoolean("DarkHistory", false)
        val lightHistory = sharedPreferences.getBoolean("LightHistory", false)

        if (lightHistory) {
            btTimeLight.text = lightText
            ibTimeLight.setImageResource(R.drawable.ic_off)
        } else {
            btTimeLight.text = getString(R.string.time_null)
            ibTimeLight.setImageResource(R.drawable.ic_on)
        }

        if (darkHistory) {
            btTimeDark.text = darkText
            ibTimeDark.setImageResource(R.drawable.ic_off)
        } else {
            btTimeDark.text = getString(R.string.time_null)
            ibTimeDark.setImageResource(R.drawable.ic_on)
        }

        ibTimeDark.setOnClickListener {
            val darkHistory2 = sharedPreferences.getBoolean("DarkHistory", false)
            if (darkHistory2) {
                editor.putBoolean("DarkHistory", false).apply()
                editor.putString("DarkText", "OFF").apply()
                btTimeDark.text = getString(R.string.time_null)
                ibTimeDark.setImageResource(R.drawable.ic_on)

                val intent = Intent(activity, AutoChangeDark::class.java)
                val pendingIntent = getBroadcast(activity, 1, intent, flags)
                alarmManager.cancel(pendingIntent)
                Toast.makeText(activity, getString(R.string.stop_theme), Toast.LENGTH_SHORT).show()
            } else {
                val calendar = Calendar.getInstance()
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val year = calendar[Calendar.YEAR]
                val month = calendar[Calendar.MONTH]
                val day = calendar[Calendar.DAY_OF_MONTH]
                val timePickerDialog = TimePickerDialog(activity, { _, i, i1 ->
                    val timeToNotify = "$i:$i1"
                    val dateToNotify = day.toString() + "-" + (month + 1) + "-" + year
                    val dateAndTime = "$dateToNotify $timeToNotify"
                    val df = SimpleDateFormat("d-M-yyyy HH:mm")
                    time = df.parse(dateAndTime)!!.time
                    if (time < System.currentTimeMillis()) {
                        time += 86400000
                    }
                    editor.putBoolean("DarkHistory", true).apply()
                    btTimeDark.text = formatTime24(i, i1)
                    ibTimeDark.setImageResource(R.drawable.ic_off)
                    editor.putString("DarkText", formatTime24(i, i1))
                        .apply()
                    setDark(time)
                }, hour, minute, true)//24:00
                timePickerDialog.show()
            }
        }

        ibTimeLight.setOnClickListener {
            val lightHistory2 = sharedPreferences.getBoolean("LightHistory", false)
            if (lightHistory2) {
                editor.putBoolean("LightHistory", false).apply()
                editor.putString("LightText", "OFF").apply()
                btTimeLight.text = getString(R.string.time_null)
                ibTimeLight.setImageResource(R.drawable.ic_on)

                val intent = Intent(activity, AutoChangeLight::class.java)
                val pendingIntent = getBroadcast(activity, 2, intent, flags)
                alarmManager.cancel(pendingIntent)
                Toast.makeText(activity, getString(R.string.stop_theme), Toast.LENGTH_SHORT).show()
            } else {
                val calendar = Calendar.getInstance()
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val year = calendar[Calendar.YEAR]
                val month = calendar[Calendar.MONTH]
                val day = calendar[Calendar.DAY_OF_MONTH]
                val timePickerDialog = TimePickerDialog(activity, { _, i, i1 ->
                    val timeToNotify = "$i:$i1"
                    val dateToNotify = day.toString() + "-" + (month + 1) + "-" + year
                    val dateAndTime = "$dateToNotify $timeToNotify"
                    val df = SimpleDateFormat("d-M-yyyy HH:mm")
                    time = df.parse(dateAndTime)!!.time
                    if (time < System.currentTimeMillis()) {
                        time += 86400000
                    }
                    editor.putBoolean("LightHistory", true).apply()
                    btTimeLight.text = formatTime24(i, i1)
                    ibTimeLight.setImageResource(R.drawable.ic_off)
                    editor.putString("LightText", formatTime24(i, i1)).apply()
                    setLight(time)
                }, hour, minute, true)//24:00
                timePickerDialog.show()
            }
        }
    }

    private fun setDark(timeInMillis: Long) {
        val intent = Intent(activity, AutoChangeDark::class.java)
        val pendingIntent = getBroadcast(activity, 1, intent, flags)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeInMillis,
            86400000,
            pendingIntent
        )
        Toast.makeText(activity, getString(R.string.start_theme), Toast.LENGTH_SHORT).show()
    }

    private fun setLight(timeInMillis: Long) {
        val intent = Intent(activity, AutoChangeLight::class.java)
        val pendingIntent = getBroadcast(activity, 2, intent, flags)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeInMillis,
            86400000,
            pendingIntent
        )
        Toast.makeText(activity, getString(R.string.start_theme), Toast.LENGTH_SHORT).show()
    }

    private fun formatTime(hour: Int, minute: Int): String {
        val time: String
        val formattedMinute: String = if (minute / 10 == 0) {
            "0$minute"
        } else {
            "" + minute
        }
        time = when {
            hour == 0 -> {
                "12:$formattedMinute " + resources.getString(R.string.AM)
            }
            hour < 12 -> {
                "$hour:$formattedMinute " + resources.getString(R.string.AM)
            }
            hour == 12 -> {
                "12:$formattedMinute " + resources.getString(R.string.PM)
            }
            else -> {
                val temp = hour - 12
                "$temp:$formattedMinute " + resources.getString(R.string.PM)
            }
        }

        return time
    }

    private fun formatTime24(hour: Int, minute: Int): String {
        val formattedMinute: String = if (minute / 10 == 0) {
            "0$minute"
        } else {
            "" + minute
        }
        val formattedHour: String = if (hour / 10 == 0) {
            "0$hour"
        } else {
            "" + hour
        }
        return "$formattedHour:$formattedMinute"
    }
}