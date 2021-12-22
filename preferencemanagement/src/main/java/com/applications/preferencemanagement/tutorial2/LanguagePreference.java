package com.applications.preferencemanagement.tutorial2;

import android.content.Context;
import android.util.AttributeSet;

import androidx.preference.DialogPreference;
import androidx.preference.Preference;

public class LanguagePreference extends DialogPreference implements Preference.OnPreferenceChangeListener {

    public LanguagePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }
}
