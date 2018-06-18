package com.lemuel.lemubit.nyscpack.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.lemuel.lemubit.nyscpack.view.LoginView;
import com.lemuel.lemubit.nyscpack.realm.RealmModel;
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
