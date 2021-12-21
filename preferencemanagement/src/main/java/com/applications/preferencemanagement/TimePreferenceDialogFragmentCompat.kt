package com.applications.preferencemanagement

import android.R
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.View
import android.widget.TimePicker
import androidx.preference.DialogPreference
import androidx.preference.PreferenceDialogFragmentCompat


class TimePreferenceDialogFragmentCompat: PreferenceDialogFragmentCompat() {
    private lateinit var mTimePicker: TimePicker

    companion object {
        fun newInstance(
            key: String?
        ): TimePreferenceDialogFragmentCompat? {
            val fragment = TimePreferenceDialogFragmentCompat()
            val b = Bundle(1)
            b.putString(ARG_KEY, key)
            fragment.arguments = b
            return fragment
        }    }

    override fun onDialogClosed(positiveResult: Boolean) {
        if (positiveResult) {
            // generate value to save
            val hours = mTimePicker.currentHour
            val minutes = mTimePicker.currentMinute
            val minutesAfterMidnight = hours * 60 + minutes

            // Get the related Preference and save the value
            val preference = preference
            if (preference is TimePreference) {
                val timePreference = preference
                // This allows the client to ignore the user value.
                if (timePreference.callChangeListener(
                        minutesAfterMidnight
                    )
                ) {
                    // Save the value
                    timePreference.setTime(minutesAfterMidnight)
                }
            }
        }
    }

    override fun onBindDialogView(view: View) {
        super.onBindDialogView(view)
        mTimePicker = view.findViewById(R.id.edit) as TimePicker

        // Exception when there is no TimePicker
        checkNotNull(mTimePicker) {
            "Dialog view must contain" +
                    " a TimePicker with id 'edit'"
        }

        // Get the time from the related Preference
        var minutesAfterMidnight: Int? = null
        val preference: DialogPreference = preference
        if (preference is TimePreference) {
            minutesAfterMidnight = (preference as TimePreference).getTime()
        }

        // Set the time to the TimePicker
        if (minutesAfterMidnight != null) {
            val hours = minutesAfterMidnight / 60
            val minutes = minutesAfterMidnight % 60
            val is24hour: Boolean = is24HourFormat(context)
            mTimePicker.setIs24HourView(is24hour)
            mTimePicker.currentHour = hours
            mTimePicker.currentMinute = minutes
        }
    }
}