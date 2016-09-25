package com.example.realmdb;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Anand on 25/09/2016.
 */
public class RealmDbApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("example.realm")
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
