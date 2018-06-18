package com.lemuel.lemubit.nyscpack.presenter;


import android.content.Context;

/**
 * @author lemuel
 */
public interface LoginPresenter {
    void saveEmail(String email);
    void getSavedEmails(Context context);
}
