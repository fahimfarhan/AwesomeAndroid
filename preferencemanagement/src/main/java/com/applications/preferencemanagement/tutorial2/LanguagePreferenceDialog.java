package com.applications.preferencemanagement.tutorial2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.applications.preferencemanagement.R;

public class LanguagePreferenceDialog extends RoundedPreferenceDialog {

    public static LanguagePreferenceDialog newInstance() {
        return new LanguagePreferenceDialog();
    }

    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.dialogpreference_language, container, false);

        // init UI, list adapter, listeners

        return view;
    }
}
