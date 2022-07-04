package com.schneewittchen.aiotr.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.schneewittchen.aiotr.domain.RosDomain;
import com.schneewittchen.aiotr.model.repositories.rosRepo.message.RosData;
import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;
import com.schneewittchen.aiotr.model.entities.widgets.BaseEntity;

import java.util.List;


/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.2
 * @created on 10.01.20
 * @updated on 21.04.20
 * @modified by Nils Rottmann
 */
public class VizViewModel extends AndroidViewModel {

    private static final String TAG = VizViewModel.class.getSimpleName();

    private final RosDomain rosDomain;

    public VizViewModel(@NonNull Application application) {
        super(application);

        rosDomain = RosDomain.getInstance(application);
    }

    public void createWidget(String widgetType) {
        rosDomain.createWidget(null, widgetType);
    }

    public void updateWidget(BaseEntity widget) {
        rosDomain.updateWidget(null, widget);
    }

    public LiveData<List<BaseEntity>> getCurrentWidgets() {
        return rosDomain.getCurrentWidgets();
    }

    public LiveData<RosData> getData() {
        return this.rosDomain.getData();
    }


    public void publishData(BaseData data) {
        rosDomain.publishData(data);
    }
}
