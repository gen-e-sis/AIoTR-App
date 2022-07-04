package com.schneewittchen.aiotr.ui.views.widgets;

import com.schneewittchen.aiotr.model.repositories.rosRepo.node.BaseData;
import com.schneewittchen.aiotr.ui.general.DataListener;

/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 10.03.21
 */
public interface IPublisherView {

    void publishViewData(BaseData data);
    void setDataListener(DataListener listener);
}
