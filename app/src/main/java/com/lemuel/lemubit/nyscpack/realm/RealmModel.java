package com.lemuel.lemubit.nyscpack.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class RealmModel extends RealmObject {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void saveNewEmail(String email, Context context) {
        Realm.init(context);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmModel user = realm.createObject(RealmModel.class);
        user.setEmail(email);
        realm.commitTransaction();
    }

    public String[] getEmails(Context context) {
        Realm.init(context);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<RealmModel> results = realm.where(RealmModel.class).distinctValues("email").findAll();
        String[] resultArray = new String[results.size()];
        int increment = 0;
        for (RealmModel s : results) {
            resultArray[increment] = s.getEmail();
            increment++;
        }
        return resultArray;
    }
}
