package com.lemuel.lemubit.nyscpack.view;

import android.support.v7.widget.RecyclerView;


/**
 * View interface for MainActivity
 * @author lemuel
 */
public interface MainActivityView {
    /**
     * Sets recycler view adapter for the chosen Recyclerview
     * @param adapter Desired adapter
     */
    void onSetRecyclerAdapter(RecyclerView.Adapter adapter);

    /**
     * Ses the layout manager for the chosen Recyclerview
     * @param layoutManager Desired layout manager
     */
    void onSetLayoutManager(RecyclerView.LayoutManager layoutManager);
}
