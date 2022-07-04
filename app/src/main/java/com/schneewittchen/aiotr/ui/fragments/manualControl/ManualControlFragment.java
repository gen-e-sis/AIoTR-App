package com.schneewittchen.aiotr.ui.fragments.manualControl;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.schneewittchen.aiotr.R;
import com.schneewittchen.aiotr.model.entities.widgets.BaseEntity;
import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;

import org.jetbrains.annotations.NotNull;

import com.schneewittchen.aiotr.ui.general.DataListener;
import com.schneewittchen.aiotr.ui.general.TabButton;
import com.schneewittchen.aiotr.widgets.joystick.JoystickView;

public class ManualControlFragment extends Fragment implements DataListener {

    private final static String TAG = ManualControlFragment.class.getSimpleName();
    private RyanViewModel ryanViewModel; // fucking love coding don't we
    private static JoystickView joystick;
    private static BaseEntity joystickEntity;

    public static ManualControlFragment newInstance() {
        return new ManualControlFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manual_control, container, false);

        TabButton homeButton = new TabButton(v.findViewById(R.id.home_button_mc));
        homeButton.linkToFragment(0, getParentFragmentManager().beginTransaction());

        joystick = v.findViewById(R.id.joystick);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ryanViewModel = new ViewModelProvider(this).get(RyanViewModel.class);

        ryanViewModel.createWidget("Joystick");

        joystickEntity = ryanViewModel.retrieveJoystick();
        joystick.setWidgetEntity(joystickEntity);

    }

    @Override
    public void onNewWidgetData(BaseData data) {
        Log.d(TAG, "onNewWidgetData: fuck");
        ryanViewModel.publishData(data);

    }

}