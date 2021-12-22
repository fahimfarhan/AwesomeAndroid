package com.applications.preferencemanagement.tutorial2;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class RoundedPreferenceDialog extends DialogFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       /* if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // remove default background so that dialog can be rounded
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);  // remove default title
        }*/
        super.onViewCreated(view, savedInstanceState);
    }
}
