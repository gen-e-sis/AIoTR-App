package com.schneewittchen.aiotr.ui.views.widgets;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.schneewittchen.aiotr.model.repositories.rosRepo.message.Topic;
import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;
import com.schneewittchen.aiotr.ui.general.DataListener;


/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 10.03.21
 */
public abstract class PublisherWidgetView extends WidgetView implements IPublisherView{

    public static String TAG = PublisherWidgetView.class.getSimpleName();

    private DataListener dataListener;


    public PublisherWidgetView(Context context) {
        super(context);
    }

    public PublisherWidgetView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void publishViewData(BaseData data) {
        if(dataListener == null) return;

        if(widgetEntity == null) data.setTopic(new Topic("unnamed", "untyped"));
        else data.setTopic(widgetEntity.topic);

        dataListener.onNewWidgetData(data);
    }

    @Override
    public void setDataListener(DataListener listener) {
        this.dataListener = listener;
    }

}
