package com.phstudio.darktheme.Fragments

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.phstudio.darktheme.R
import java.text.SimpleDateFormat
import java.util.*

class SchedulerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scheduler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val timedark = view.findViewById<Button>(R.id.timedark)
        val timelight = view.findViewById<Button>(R.id.timelight)
        val buttondark = view.findViewById<ImageButton>(R.id.buttondark)
        val buttonlight = view.findViewById<ImageButton>(R.id.buttonlight)

        var time: Long

        val sharedPreferences = requireActivity().getSharedPreferences(
            resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        )
        val editor = requireActivity().getSharedPreferences(
            resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        ).edit()

        val DarkText = sharedPreferences.getString("DarkText", "")
        val LightText = sharedPreferences.getString("LightText", "")

        val DarkHistory = sharedPreferences.getBoolean("DarkHistory", false)
        val LightHistory = sharedPreferences.getBoolean("LightHistory", false)

        if (LightHistory) {
            timelight.text = LightText
            buttonlight.setImageResource(R.drawable.off)
        } else {
            timelight.text = getString(R.string.timenull)
            buttonlight.setImageResource(R.drawable.on)
        }

        if (DarkHistory) {
            timedark.text = DarkText
            buttondark.setImageResource(R.drawable.off)
        } else {
            timedark.text = getString(R.string.timenull)
            buttondark.setImageResource(R.drawable.on)
        }

        buttondark.setOnClickListener {
            val DarkHistory2 = sharedPreferences.getBoolean("DarkHistory", false)
            if (DarkHistory2) {
                editor.putBoolean("DarkHistory", false).apply()
                editor.putString("DarkText", "OFF").apply()
                timedark.text = getString(R.string.timenull)
                buttondark.setImageResource(R.drawable.on)

                val alarmManager =
                    requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val intent = Intent(activity, AutoChangeDark::class.java)
                val pendingIntent = PendingIntent.getBroadcast(activity, 1, intent, 0)
                alarmManager.cancel(pendingIntent)
                Toast.makeText(activity, getString(R.string.stoptheme), Toast.LENGTH_SHORT).show()
            } else {
                val calendar = Calendar.getInstance()
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val year = calendar[Calendar.YEAR]
                val month = calendar[Calendar.MONTH]
                val day = calendar[Calendar.DAY_OF_MONTH]
                val timePickerDialog = TimePickerDialog(activity, { timePicker, i, i1 ->
                    val timeTonotify = "$i:$i1"
                    val dateTonotify = day.toString() + "-" + (month + 1) + "-" + year
                    val dateandtime = "$dateTonotify $timeTonotify"
                    val df = SimpleDateFormat("d-M-yyyy HH:mm")
                    time = df.parse(dateandtime).time
                    if (time < System.currentTimeMillis()) {
                        time += 86400000
                    }
                    editor.putBoolean("DarkHistory", true).apply()
                    timedark.text = formatetime24(i, i1)
                    buttondark.setImageResource(R.drawable.off)
                    editor.putString("DarkText", formatetime24(i, i1))
                        .apply()
                    setDark(time)
                }, hour, minute, true)//24:00
                timePickerDialog.show()
            }
        }

        buttonlight.setOnClickListener {
            val LightHistory2 = sharedPreferences.getBoolean("LightHistory", false)
            if (LightHistory2) {
                editor.putBoolean("LightHistory", false).apply()
                editor.putString("LightText", "OFF").apply()
                timelight.text = getString(R.string.timenull)
                buttonlight.setImageResource(R.drawable.on)

                val alarmManager =
                    requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val intent = Intent(activity, AutoChangeLight::class.java)
                val pendingIntent = PendingIntent.getBroadcast(activity, 2, intent, 0)
                alarmManager.cancel(pendingIntent)
                Toast.makeText(activity, getString(R.string.stoptheme), Toast.LENGTH_SHORT).show()
            } else {
                val calendar = Calendar.getInstance()
                val hour = calendar[Calendar.HOUR_OF_DAY]
                val minute = calendar[Calendar.MINUTE]
                val year = calendar[Calendar.YEAR]
                val month = calendar[Calendar.MONTH]
                val day = calendar[Calendar.DAY_OF_MONTH]
                val timePickerDialog = TimePickerDialog(activity, { timePicker, i, i1 ->
                    val timeTonotify = "$i:$i1"
                    val dateTonotify = day.toString() + "-" + (month + 1) + "-" + year
                    val dateandtime = "$dateTonotify $timeTonotify"
                    val df = SimpleDateFormat("d-M-yyyy HH:mm")
                    time = df.parse(dateandtime).time
                    if (time < System.currentTimeMillis()) {
                        time += 86400000
                    }
                    editor.putBoolean("LightHistory", true).apply()
                    timelight.text = formatetime24(i, i1)
                    buttonlight.setImageResource(R.drawable.off)
                    editor.putString("LightText", formatetime24(i, i1)).apply()
                    setLight(time)
                }, hour, minute, true)//24:00
                timePickerDialog.show()
            }
        }
    }

    private fun setDark(timeInMillis: Long) {
        val alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(activity, AutoChangeDark::class.java)
        val pendingIntent = PendingIntent.getBroadcast(activity, 1, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeInMillis,
            86400000,
            pendingIntent
        )
        Toast.makeText(activity, getString(R.string.starttheme), Toast.LENGTH_SHORT).show()
    }

    private fun setLight(timeInMillis: Long) {
        val alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(activity, AutoChangeLight::class.java)
        val pendingIntent = PendingIntent.getBroadcast(activity, 2, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            timeInMillis,
            86400000,
            pendingIntent
        )
        Toast.makeText(activity, getString(R.string.starttheme), Toast.LENGTH_SHORT).show()
    }

    private fun FormatTime(hour: Int, minute: Int): String {
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

    private fun formatetime24(hour: Int, minute: Int): String {
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