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

package com.lemuel.lemubit.nyscpack.Realm;

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
