package com.example.realmdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.realmdb.models.Task;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Task t = realm.createObject(Task.class);
                t.setId(UUID.randomUUID().toString());
                t.setTitle("First task");
                t.setDescription("This is the first task");
            }
        });

        RealmResults<Task> tasks = realm.where(Task.class).findAll();
        for(Task t : tasks){
            Log.d("Realm", t.getTitle());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        realm.close();
    }
}
