package com.applications.preferencemanagement.tutorial4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.applications.preferencemanagement.R;

public class DemoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentRootVIew = inflater.inflate(R.layout.demo, container, false);
        fragmentRootVIew.setOnClickListener(v -> {});
        return fragmentRootVIew;
    }
}
