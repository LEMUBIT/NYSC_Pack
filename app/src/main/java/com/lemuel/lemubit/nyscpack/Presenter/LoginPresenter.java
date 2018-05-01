package com.lemuel.lemubit.nyscpack.Presenter;


import android.content.Context;

public interface LoginPresenter {
    void saveEmail(String email);
    void getSavedEmails(Context context);
}
