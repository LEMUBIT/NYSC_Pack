package com.lemuel.lemubit.nyscpack;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.lemuel.lemubit.nyscpack.presenter.MainActivityPresenter;
import com.lemuel.lemubit.nyscpack.view.MainActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lemuel
 */
//todo add activities to Views in the MVP, they are actually the views

public class MainActivity extends AppCompatActivity implements MainActivityView {
    //todo this main activity will have necessary features using lottie files
    //todo design home and questions activity.

    @BindView(R.id.mainMenuRcyView)
    RecyclerView mainMenuRecyclerV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this, this);
        mainActivityPresenter.setMenuRecyclerAdapter();
        mainActivityPresenter.setLayoutManager();
    }

    @Override
    public void onSetRecyclerAdapter(RecyclerView.Adapter adapter) {
        mainMenuRecyclerV.setAdapter(adapter);
    }

    @Override
    public void onSetLayoutManager(RecyclerView.LayoutManager layoutManager) {
        mainMenuRecyclerV.setLayoutManager(layoutManager);
    }
}
