package com.applications.preferencemanagement.tutorial4;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.preference.ListPreference;

import com.applications.preferencemanagement.R;

public class AwesomeListPreference extends ListPreference {
    public static final String TAG = "AwesomeListPreference";
    private int mDialogResource = R.layout.awesome_list_preference;

    public AwesomeListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public AwesomeListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AwesomeListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AwesomeListPreference(Context context) {
        super(context);
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return super.onGetDefaultValue(a, index);
    }

    @Override
    protected void onSetInitialValue(Object defaultValue) {
        super.onSetInitialValue(defaultValue);
    }

    @Override
    public int getDialogLayoutResource() {
        return mDialogResource; // super.getDialogLayoutResource();
    }
}
