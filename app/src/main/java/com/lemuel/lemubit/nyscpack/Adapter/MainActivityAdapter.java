package com.lemuel.lemubit.nyscpack.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lemuel.lemubit.nyscpack.Model.HomeMenuItems;
import com.lemuel.lemubit.nyscpack.R;
import com.lemuel.lemubit.nyscpack.View.MainActivityView;

import java.util.List;

import butterknife.BindView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    Context context;
    MainActivityView mainActivityView;
    List <HomeMenuItems> homeMenuItemsList;

    public MainActivityAdapter(Context context, MainActivityView mainActivityView, List<HomeMenuItems> homeMenuItemsList) {
        this.context = context;
        this.mainActivityView = mainActivityView;
        this.homeMenuItemsList = homeMenuItemsList;
    }

    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_menu_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return homeMenuItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
