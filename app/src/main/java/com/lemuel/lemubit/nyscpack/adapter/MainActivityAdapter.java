package com.lemuel.lemubit.nyscpack.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.lemuel.lemubit.nyscpack.R;
import com.lemuel.lemubit.nyscpack.model.HomeMenuItems;
import com.lemuel.lemubit.nyscpack.view.MainActivityView;

import java.util.List;

/**
 * @author lemuel
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    Context context;
    MainActivityView mainActivityView;
    List<HomeMenuItems> homeMenuItemsList;

    public MainActivityAdapter(Context context, MainActivityView mainActivityView, List<HomeMenuItems> homeMenuItemsList) {
        this.context = context;
        this.mainActivityView = mainActivityView;
        this.homeMenuItemsList = homeMenuItemsList;
    }

    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityAdapter.ViewHolder holder, int position) {
        holder.menuDescription.setText(homeMenuItemsList.get(position).getDescription());
        holder.menuLottieAnimationView.setAnimation(homeMenuItemsList.get(position).getLottieAnimation());
        holder.menuLottieAnimationView.setRepeatCount(1);
        holder.menuLottieAnimationView.playAnimation();
    }

    @Override
    public int getItemCount() {
        return homeMenuItemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LottieAnimationView menuLottieAnimationView;
        public TextView menuDescription;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            menuLottieAnimationView = itemView.findViewById(R.id.menu_animation_view);
            menuDescription = itemView.findViewById(R.id.menuDescriptionTxt);
            view = itemView.findViewById(R.id.description_divider_view);

        }
    }
}
