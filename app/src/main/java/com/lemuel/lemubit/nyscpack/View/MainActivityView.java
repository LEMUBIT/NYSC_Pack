package com.lemuel.lemubit.nyscpack.View;

import android.support.v7.widget.RecyclerView;

import com.lemuel.lemubit.nyscpack.Model.HomeMenuItems;

import java.util.ArrayList;
import java.util.List;

public interface MainActivityView {
    void onSetRecyclerAdapter(RecyclerView.Adapter adapter);
    void onSetLayoutManager(RecyclerView.LayoutManager layoutManager);
}
