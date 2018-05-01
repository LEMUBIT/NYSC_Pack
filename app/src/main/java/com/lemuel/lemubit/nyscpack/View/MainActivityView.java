package com.lemuel.lemubit.nyscpack.View;

import com.lemuel.lemubit.nyscpack.Model.HomeMenuItems;

import java.util.ArrayList;
import java.util.List;

public interface MainActivityView {
    void onSetRecyclerAdapter(List <HomeMenuItems> homeMenuItemsArrayList);
}
