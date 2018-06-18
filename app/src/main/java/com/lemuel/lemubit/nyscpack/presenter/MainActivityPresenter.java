package com.lemuel.lemubit.nyscpack.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.lemuel.lemubit.nyscpack.adapter.MainActivityAdapter;
import com.lemuel.lemubit.nyscpack.model.HomeMenuItems;
import com.lemuel.lemubit.nyscpack.R;
import com.lemuel.lemubit.nyscpack.view.MainActivityView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityPresenter {
    private List<String> menuLottieFilRefs = new ArrayList<>();
    private List<String> menuDescriptions = new ArrayList<>();
    private List<HomeMenuItems> homeMenuItemsList = new ArrayList<>();
    Context context;
    MainActivityView mainActivityView;

    public MainActivityPresenter(Context context, MainActivityView mainActivityView) {
        this.context = context;
        this.mainActivityView = mainActivityView;
    }

    public void setMenuRecyclerAdapter() {
        menuLottieFilRefs = Arrays.asList(context.getResources().getStringArray(R.array.home_menu_items_lottie));
        menuDescriptions = Arrays.asList(context.getResources().getStringArray(R.array.home_menu_items_description));

        //todo use Dimens resource for number of menu items
        /* There are only 6 menu items (0-5) */
        for (int i = 0; i <= 5; i++) {
            homeMenuItemsList.add(i, new HomeMenuItems(menuLottieFilRefs.get(i), menuDescriptions.get(i)));
        }
        mainActivityView.onSetRecyclerAdapter(new MainActivityAdapter(context, mainActivityView, homeMenuItemsList));
    }

    public void setLayoutManager() {
        mainActivityView.onSetLayoutManager(new GridLayoutManager(context, 2));
    }

}
