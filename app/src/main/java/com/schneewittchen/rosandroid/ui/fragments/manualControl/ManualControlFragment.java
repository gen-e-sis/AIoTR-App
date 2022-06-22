package com.schneewittchen.rosandroid.ui.fragments.manualControl;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.schneewittchen.rosandroid.R;
import com.schneewittchen.rosandroid.domain.RosDomain;
import com.schneewittchen.rosandroid.ui.fragments.map.MapxusFragment;

import org.jetbrains.annotations.NotNull;

import com.schneewittchen.rosandroid.ui.general.TabButton;
import com.schneewittchen.rosandroid.widgets.joystick.JoystickView;

import java.util.Objects;

import sensor_msgs.Joy;

public class ManualControlFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manual_control, container, false);

        TabButton homeButton = new TabButton(v.findViewById(R.id.home_button_mc));
        homeButton.linkToFragment(0, getParentFragmentManager().beginTransaction());

        //fucking disgusting code
//        RosDomain instance = RosDomain.getInstance(this.requireActivity().getApplication());
        //widget creation system
//        instance.createWidget(v.getUniqueDrawingId(),"Joystick");
        /*
        For future reference, widget type is one of:
        - Joystick
        - Battery
        - Button
        - Camera
        - Debug
        - Label
        - Logger
        - Viz2D
        - RqtPlot
         */

        return v;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    
}