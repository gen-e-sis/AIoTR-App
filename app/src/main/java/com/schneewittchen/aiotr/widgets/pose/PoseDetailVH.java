package com.schneewittchen.aiotr.widgets.pose;

import android.view.View;

import com.schneewittchen.aiotr.model.entities.widgets.BaseEntity;
import com.schneewittchen.aiotr.ui.views.details.SubscriberLayerViewHolder;

import java.util.Collections;
import java.util.List;

import geometry_msgs.PoseWithCovarianceStamped;


/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 21.03.21
 */
public class PoseDetailVH extends SubscriberLayerViewHolder {


    @Override
    protected void initView(View parentView) {

    }

    @Override
    protected void bindEntity(BaseEntity entity) {

    }

    @Override
    protected void updateEntity(BaseEntity entity) {

    }

    @Override
    public List<String> getTopicTypes() {
        return Collections.singletonList(PoseWithCovarianceStamped._TYPE);
    }
}
