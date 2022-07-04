package com.schneewittchen.aiotr.ui.views.widgets;

import android.content.Context;

import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;
import com.schneewittchen.aiotr.ui.general.DataListener;
import com.schneewittchen.aiotr.ui.opengl.visualisation.VisualizationView;

import javax.microedition.khronos.opengles.GL10;


/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 10.03.21
 */
public abstract class PublisherLayerView extends LayerView implements IPublisherView{

    private DataListener dataListener;


    public PublisherLayerView(Context context) {
        super(context);
    }


    @Override
    public void publishViewData(BaseData data) {
        if(dataListener == null) return;

        data.setTopic(widgetEntity.topic);
        dataListener.onNewWidgetData(data);
    }

    @Override
    public void setDataListener(DataListener listener) {
        this.dataListener = listener;
    }

    @Override
    public void draw(VisualizationView view, GL10 gl) {}
}
