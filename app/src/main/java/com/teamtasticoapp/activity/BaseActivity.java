package com.teamtasticoapp.activity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.teamtasticoapp.application.TeamtasticoApplication;

/**
 * Created by junaid on 10/31/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected TeamtasticoApplication mMyApp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyApp = TeamtasticoApplication.getInstance();
        mMyApp.setVisible(true);
    }

    protected void onResume() {
        super.onResume();
        mMyApp.setVisible(true);
        mMyApp.setCurrentActivity(this);
    }

    protected void onPause() {
        clearReferences();
        super.onPause();
    }

    protected void onDestroy() {
        clearReferences();
        super.onDestroy();
    }

    private void clearReferences() {
        Activity currActivity = mMyApp.getCurrentActivity();
        if (this.equals(currActivity)) {
            //mMyApp.setCurrentActivity(null);
            mMyApp.setVisible(false);
        }
    }
}
