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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lemuel.lemubit.nyscpack.Realm.RealmModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class Login extends AppCompatActivity {
    @BindView(R.id.autoLoginEmailTxt)
    AutoCompleteTextView EmailTxt;
    @BindView(R.id.LoginPassTxt)
    EditText passwordTxt;
    @BindView(R.id.LoginBtn)
    Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        // Initialize Realm
        Realm.init(this);
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();
        RealmResults<RealmModel> results = realm.where(RealmModel.class).distinctValues("email").findAll();
        String[] resultArray = new String[results.size()];
        int increment = 0;
        for (RealmModel s : results) {
            resultArray[increment] = s.getEmail();
            increment++;
        }
        //Get Emails from Realm into auto-correct text
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, resultArray);
        EmailTxt.setAdapter(adapter);

        LoginBtn.setOnClickListener(v -> {

            //Save email
            realm.beginTransaction();
            RealmModel user = realm.createObject(RealmModel.class);
            user.setEmail(EmailTxt.getText().toString());
            realm.commitTransaction();
        });

    }
}
