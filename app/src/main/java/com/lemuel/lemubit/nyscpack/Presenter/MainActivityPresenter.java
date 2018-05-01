package com.lemuel.lemubit.nyscpack.Presenter;

import android.content.Context;

import com.lemuel.lemubit.nyscpack.Model.HomeMenuItems;
import com.lemuel.lemubit.nyscpack.R;
import com.lemuel.lemubit.nyscpack.View.MainActivityView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityPresenter {
    private  List<String> menuLottieFilRefs = new ArrayList<>();
    private  List<String> menuDescriptions = new ArrayList<>();
    private  List<HomeMenuItems> homeMenuItemsList=new ArrayList<>();
    Context context;
    MainActivityView mainActivityView;

    public MainActivityPresenter(Context context, MainActivityView mainActivityView) {
        this.context = context;
        this.mainActivityView=mainActivityView;
    }

    public void setMenuRecyclerAdapter() {
        menuLottieFilRefs=Arrays.asList(context.getResources().getStringArray(R.array.home_menu_items_lottie));
        menuDescriptions = Arrays.asList(context.getResources().getStringArray(R.array.home_menu_items_description));

        /* There are only 5 menu items (0-4) */
        for(int i=0; i<=4; i++)
        {
            homeMenuItemsList.add(i,new HomeMenuItems(menuLottieFilRefs.get(i),menuDescriptions.get(i)));
        }
        mainActivityView.onSetRecyclerAdapter(homeMenuItemsList);
    }

}
