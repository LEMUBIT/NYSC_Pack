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

package com.lemuel.lemubit.nyscpack.Presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.lemuel.lemubit.nyscpack.View.LoginView;
import com.lemuel.lemubit.nyscpack.Realm.RealmModel;

import io.realm.Realm;
import io.realm.RealmResults;


public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;
    Realm realm;

    public LoginPresenterImpl(Context context, LoginView loginView) {
        // Initialize Realm
        Realm.init(context);
        this.loginView = loginView;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void saveEmail(String email) {
        //Save email
        realm.beginTransaction();
        RealmModel user = realm.createObject(RealmModel.class);
        user.setEmail(email);
        realm.commitTransaction();
    }

    @Override
    public void getSavedEmails(Context context) {
        RealmResults<RealmModel> results = realm.where(RealmModel.class).distinctValues("email").findAll();
        String[] resultArray = new String[results.size()];
        int increment = 0;
        for (RealmModel s : results) {
            resultArray[increment] = s.getEmail();
            increment++;
        }
        //Get Emails from Realm into auto-correct text
        ArrayAdapter<String> adapter = new ArrayAdapter(context,
                android.R.layout.simple_dropdown_item_1line, resultArray);

        loginView.onSetAutoCompleterText(adapter);
    }
}
