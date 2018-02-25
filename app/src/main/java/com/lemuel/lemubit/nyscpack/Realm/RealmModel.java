package com.lemuel.lemubit.nyscpack.Realm;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class RealmModel extends RealmObject{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
