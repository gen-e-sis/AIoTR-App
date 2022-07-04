
/*
Created by Ryan Zhang.

Implemented by Ryan Zhang.

This is my only fucking contribution to this app.
 */

package com.schneewittchen.aiotr.ui.general;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import com.schneewittchen.aiotr.R;
import com.schneewittchen.aiotr.ui.fragments.details.DetailMainFragment;
import com.schneewittchen.aiotr.ui.fragments.home.HomeFragment;
import com.schneewittchen.aiotr.ui.fragments.manualControl.ManualControlFragment;
import com.schneewittchen.aiotr.ui.fragments.map.MapxusFragment;
import com.schneewittchen.aiotr.ui.fragments.master.MasterFragment;
import com.schneewittchen.aiotr.ui.fragments.settings.SettingsFragment;
import com.schneewittchen.aiotr.ui.fragments.smartHomeControl.SmartHomeControlFragment;
import com.schneewittchen.aiotr.ui.fragments.ssh.SshFragment;
import com.schneewittchen.aiotr.ui.fragments.robotarm.RobotarmFragment;

import java.lang.String;

public class TabButton {

    public final static String TAG = "TabButton";

    private Button btn;
    NavController navController;


    public TabButton(Button initButton) {
        btn = initButton;
//        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container);

    }

    public Button get() {return btn;}
    public void set(Button setButton) {btn = setButton;}

//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
////        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container);
//
//    }


    public void linkToFragment(final int FragmentType, final FragmentTransaction ft) {
        /*
        FragmentType : FragmentName
        0 : HomeFragment
        1 : MapxusFragment
        2 : SettingsFragment
        3 : MasterFragment
        4 : SshFragment
        5 : SmartHomeControlFragment
        6 : RobotArmFragment
        7 : ManualControlFragment
        8 : DetailMainFragment
         */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (FragmentType) {
                    case 0:
                        ft.replace(R.id.main_container, new HomeFragment());
                        break;
                    case 1:
                        ft.replace(R.id.main_container, new MapxusFragment());
                        break;
                    case 2:
                        ft.replace(R.id.main_container, new SettingsFragment());
                        break;
                    case 3:
                        ft.replace(R.id.main_container, new MasterFragment());
                        break;
                    case 4:
                        ft.replace(R.id.main_container, new SshFragment());
                        break;
                    case 5:
                        ft.replace(R.id.main_container, new SmartHomeControlFragment());
                        break;
                    case 6:
                        ft.replace(R.id.main_container, new RobotarmFragment());
                        break;
                    case 7:
                        ft.replace(R.id.main_container, new ManualControlFragment());
                        break;
                    case 8:
                        ft.replace(R.id.main_container, new DetailMainFragment());
                        break;
                    default:
                        Log.e(TAG, "onClick: Fragment type invalid. Tried" + FragmentType);
                }
                ft.commit();
            }
        });
    }

}
