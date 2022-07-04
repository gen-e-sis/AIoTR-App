package com.schneewittchen.aiotr.ui.fragments.settings;

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

public class SettingsFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        TabButton homeButton = new TabButton(v.findViewById(R.id.home_button));
        homeButton.linkToFragment(0, getParentFragmentManager().beginTransaction());

        TabButton masterButton = new TabButton(v.findViewById(R.id.master_button));
        masterButton.linkToFragment(3, getParentFragmentManager().beginTransaction());

        TabButton sshButton = new TabButton(v .findViewById(R.id.ssh_button));
        sshButton.linkToFragment(4, getParentFragmentManager().beginTransaction());

        TabButton detailsButton = new TabButton(v.findViewById(R.id.details_button));
        detailsButton.linkToFragment(8, getParentFragmentManager().beginTransaction());
//        Button detailsButton = v.findViewById(R.id.details_button);
//        detailsButton.setOnClickListener(v1 -> {
//            NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment_container);
//            navController.navigate(R.id.action_to_detailFragment);
//        });
//        detailsButton.linkToFragment(8, getParentFragmentManager().beginTransaction());

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

