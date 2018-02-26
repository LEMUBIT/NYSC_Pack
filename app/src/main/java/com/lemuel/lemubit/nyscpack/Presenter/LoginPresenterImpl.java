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



public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;
    Realm realm;
    RealmModel realmModel = new RealmModel();
    Context context;

    public LoginPresenterImpl(Context context, LoginView loginView) {
        // Initialize Realm
        Realm.init(context);
        this.context = context;
        this.loginView = loginView;
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void saveEmail(String email) {
        //Save email
        realmModel.saveNewEmail(email, context);
    }

    @Override
    public void getSavedEmails(Context context) {

        //Get Emails from Realm into auto-correct text
        ArrayAdapter<String> adapter = new ArrayAdapter(context,
                android.R.layout.simple_dropdown_item_1line, realmModel.getEmails(context));
        loginView.onSetAutoCompleterText(adapter);
    }
}
