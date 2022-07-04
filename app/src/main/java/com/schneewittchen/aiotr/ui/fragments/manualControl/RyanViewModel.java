package com.schneewittchen.aiotr.ui.fragments.manualControl;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.schneewittchen.aiotr.domain.RosDomain;
import com.schneewittchen.aiotr.model.entities.widgets.BaseEntity;
import com.schneewittchen.aiotr.model.repositories.ConfigRepository;
import com.schneewittchen.aiotr.model.repositories.ConfigRepositoryImpl;
import com.schneewittchen.aiotr.model.repositories.rosRepo.message.RosData;
import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RyanViewModel extends AndroidViewModel {

    private final String TAG = RyanViewModel.class.getSimpleName();

    public static MutableLiveData<List<Long>> selectedPath;
    private final RosDomain rosDomain;

    private ConfigRepository config;
    private MediatorLiveData<String> configTitle;
    private LiveData<RosData> rosData;

    public RyanViewModel(@NonNull @NotNull Application application) {
        super(application);

        config = ConfigRepositoryImpl.getInstance(getApplication());

        rosDomain = RosDomain.getInstance(application);

        rosData = rosDomain.getData();
        rosData.observeForever(data -> {
            if(data.getTopic().name.equals("cmd_vel")) {
                Log.d(TAG, "RyanViewModel: pp dick topic: "+data.getTopic().name+" "+data.getTopic().type);
                Log.d(TAG, "RyanViewModel: fuck");
            }
            Log.d(TAG, "RyanViewModel: sum fuck in data: "+data.getTopic().name+" "+data.getTopic().type);
        });

        if (selectedPath == null) {
            selectedPath = new MutableLiveData<>();
            selectedPath.setValue(new ArrayList<>());
        }

    }

    public void createWidget(String dick) {
        rosDomain.createWidget(getParentId(0), dick);
    }

    public void addWidget(BaseEntity widget) {
        rosDomain.addWidget(getParentId(0), widget);
    }

    private Long getParentId(int branch) {
        Long parentId = null;
        List<Long> path = selectedPath.getValue();

        if (path.size() > branch) {
            parentId = path.get(0);
        }

        return parentId;
    }

    public void publishData(BaseData data) {
        Log.d(TAG, "publishData: ryan is a fuck");
        rosDomain.publishData(data);
    }

    public BaseEntity retrieveJoystick() {
        return rosDomain.findWidget(0).getValue();
    }

    public void createFirstConfig(String name) {
        config.createConfig(name);
    }

    public LiveData<String> getConfigTitle() {
        if (configTitle == null) {
            configTitle = new MediatorLiveData<>();

            configTitle.addSource(config.getCurrentConfig(), configuration -> {
                if (configuration == null)
                    return;

                configTitle.setValue(configuration.name);
            });
        }

        return configTitle;
    }

}
