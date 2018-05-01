/*
Copyright 2018 OGBUNUDE CHIBUEZE LEMUEL

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package com.lemuel.lemubit.nyscpack;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.lemuel.lemubit.nyscpack.Model.HomeMenuItems;
import com.lemuel.lemubit.nyscpack.Presenter.MainActivityPresenter;
import com.lemuel.lemubit.nyscpack.View.MainActivityView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainActivityView{
    //todo this main activity will have necessary features using lottie files
    //todo design home and questions activity.
    @BindView(R.id.mainMenuRcyView)
    RecyclerView mainMenuRcyV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityPresenter mainActivityPresenter=new MainActivityPresenter(this, this);
        mainActivityPresenter.setMenuRecyclerAdapter();
    }

    @Override
    public void onSetRecyclerAdapter(List<HomeMenuItems> homeMenuItemsArrayList) {
    // mainMenuRcyV.setAdapter();
    }
}
