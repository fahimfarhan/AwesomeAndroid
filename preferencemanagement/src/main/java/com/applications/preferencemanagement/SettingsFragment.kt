package com.applications.preferencemanagement

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.applications.preferencemanagement.tutorial2.LanguagePreference
import com.applications.preferencemanagement.tutorial2.LanguagePreferenceDialog
import com.applications.preferencemanagement.tutorial4.AwesomeListPreference
import com.applications.preferencemanagement.tutorial4.DemoFragment


class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.app_preferences)
    }


    override fun onDisplayPreferenceDialog(preference: Preference) {
        if (preference is LanguagePreference) {         // rounded language dialog
            LanguagePreferenceDialog.newInstance().show(parentFragmentManager, null)
        } else if(preference is AwesomeListPreference) {
            val demo = DemoFragment()
            parentFragmentManager.beginTransaction().add(android.R.id.content,demo,  "tag").addToBackStack("tag").commit()
        } else {
            super.onDisplayPreferenceDialog(preference)
        }
    }
    /*
    override fun onDisplayPreferenceDialog(preference: Preference) {
        // Try if the preference is one of our custom Preferences
        var dialogFragment: DialogFragment? = null
        if (preference is TimePreference) {
            // Create a new instance of TimePreferenceDialogFragment with the key of the related
            // Preference
            dialogFragment = TimePreferenceDialogFragmentCompat
                .newInstance(preference.getKey())
        }

        // If it was one of our cutom Preferences, show its dialog
        if (dialogFragment != null) {
            dialogFragment.setTargetFragment(this, 0)
            dialogFragment.show(
                this.requireFragmentManager(),
                "android.support.v7.preference" +
                        ".PreferenceFragment.DIALOG"
            )
        } else {
            super.onDisplayPreferenceDialog(preference)
        }
    }
*/

}