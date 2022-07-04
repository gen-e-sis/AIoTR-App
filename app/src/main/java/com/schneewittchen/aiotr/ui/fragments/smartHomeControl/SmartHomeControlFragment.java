package com.schneewittchen.aiotr.ui.fragments.smartHomeControl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.schneewittchen.aiotr.R;

import org.jetbrains.annotations.NotNull;

import com.schneewittchen.aiotr.ui.general.TabButton;

public class SmartHomeControlFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_smart_home_control, container, false);

        TabButton homeButton = new TabButton(v.findViewById(R.id.home_button_shc));
        homeButton.linkToFragment(0, getParentFragmentManager().beginTransaction());

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

