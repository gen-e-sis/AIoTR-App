package com.schneewittchen.aiotr.ui.views.details;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.schneewittchen.aiotr.R;
import com.schneewittchen.aiotr.model.entities.widgets.BaseEntity;
import com.schneewittchen.aiotr.utility.Utils;
import com.schneewittchen.aiotr.viewmodel.DetailsViewModel;

import java.util.List;


/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 17.03.21
 */
public class PublisherViewHolder implements IBaseViewHolder, TextView.OnEditorActionListener{

    public static final String TAG = PublisherViewHolder.class.getSimpleName();

    private TextInputEditText topicNameEditText;
    private TextInputEditText topicTypeEditText;
    public List<String> topicTypes;
    public DetailsViewModel viewModel;
    private DetailViewHolder parentViewHolder;


    public PublisherViewHolder(DetailViewHolder parentViewHolder) {
        this.parentViewHolder = parentViewHolder;
    }


    @Override
    public void baseInitView(View widgetView) {
        // Initialize Topic Edittext
        topicNameEditText = widgetView.findViewById(R.id.topicNameEditText);
        topicTypeEditText = widgetView.findViewById(R.id.topicTypeEditText);

        topicNameEditText.setOnEditorActionListener(this);
        topicTypeEditText.setOnEditorActionListener(this);
    }

    @Override
    public void baseBindEntity(BaseEntity entity) {
        String topicName = entity.topic.name;
        String messageType = entity.topic.type;

        topicNameEditText.setText(topicName);
        topicTypeEditText.setText(messageType);
    }

    @Override
    public void baseUpdateEntity(BaseEntity entity) {
        entity.topic.name = topicNameEditText.getText().toString();
        entity.topic.type = topicTypeEditText.getText().toString();
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId){
            case EditorInfo.IME_ACTION_DONE:
            case EditorInfo.IME_ACTION_NEXT:
            case EditorInfo.IME_ACTION_PREVIOUS:
                Utils.hideSoftKeyboard(v);
                v.clearFocus();
                parentViewHolder.forceWidgetUpdate();
                return true;
        }

        return false;
    }
}