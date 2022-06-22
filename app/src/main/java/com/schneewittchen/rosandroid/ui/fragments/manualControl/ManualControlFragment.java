package com.schneewittchen.rosandroid.ui.fragments.manualControl;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.schneewittchen.rosandroid.R;
import com.schneewittchen.rosandroid.domain.RosDomain;
import com.schneewittchen.rosandroid.model.repositories.rosRepo.node.BaseData;
import com.schneewittchen.rosandroid.ui.fragments.map.MapxusFragment;

import org.jetbrains.annotations.NotNull;

import com.schneewittchen.rosandroid.ui.general.DataListener;
import com.schneewittchen.rosandroid.ui.general.TabButton;
import com.schneewittchen.rosandroid.viewmodel.VizViewModel;
import com.schneewittchen.rosandroid.widgets.joystick.JoystickData;
import com.schneewittchen.rosandroid.widgets.joystick.JoystickView;
import com.schneewittchen.rosandroid.viewmodel.VizViewModel;
import java.util.Objects;

import sensor_msgs.Joy;

public class ManualControlFragment extends Fragment {

    private final static String TAG = ManualControlFragment.class.getSimpleName();
    private VizViewModel mViewModel; // fucking love coding don't we

    public ManualControlFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manual_control, container, false);

        TabButton homeButton = new TabButton(v.findViewById(R.id.home_button_mc));
        homeButton.linkToFragment(0, getParentFragmentManager().beginTransaction());

        mViewModel = new ViewModelProvider(this).get(VizViewModel.class);

        //mad as shit rn
        JoystickView joystick = v.findViewById(R.id.joystick);

        joystick.setDataListener(new DataListener() {
            @Override
            public void onNewWidgetData(BaseData data) {
                mViewModel.publishData(data);
//                Log.d(TAG, "onNewWidgetData: fuck this"+);
//                Log.d(TAG, "onNewWidgetData: fuck");
//                Log.d(TAG, "onNewWidgetData: fuck this "+joystick.getX()+", "+joystick.getY());
//                Log.d(TAG, "onNewWidgetData: bitch "+data.toRosMessage());
            }
        }); // I fucking code!! I fucking code!!
        //ryan's lost his fucking mind with this bitch code

        return v;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    
}