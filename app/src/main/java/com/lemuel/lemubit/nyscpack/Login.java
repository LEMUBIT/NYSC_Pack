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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lemuel.lemubit.nyscpack.Presenter.LoginPresenterImpl;
import com.lemuel.lemubit.nyscpack.View.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements LoginView {
    @BindView(R.id.autoLoginEmailTxt)
    AutoCompleteTextView EmailTxt;
    @BindView(R.id.LoginPassTxt)
    EditText passwordTxt;
    @BindView(R.id.LoginBtn)
    Button LoginBtn;
    @BindView(R.id.LoginRegisterTxt)
    TextView RegBtnTxt;
    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this, this);
        loginPresenter.getSavedEmails(this);
        LoginBtn.setOnClickListener(v -> loginPresenter.saveEmail(EmailTxt.getText().toString()));
        RegBtnTxt.setOnClickListener(v -> startActivity(new Intent(Login.this,Register.class)));
    }

    @Override
    public void onSetAutoCompleterText(ArrayAdapter<String> adapter) {
        EmailTxt.setAdapter(adapter);
    }
}
