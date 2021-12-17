package com.teamtasticoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.teamtasticoapp.R;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

/**
 * Created by mobulous55 on 13/3/18.
 */

public class Splash extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Whenever an object is instantiated but is not assigned a reference variable,
        //it is called anonymous object instantiation.

       /* Simple object instantiation:
        Sample s = new Sample();*/

       /* Anonymous object instantiation:
        new Sample();*/


        //Simple object instantiation:
        /* Handler h = new Handler();
        h.postDelayed(new Runnable()*/

        //Anonymous object instantiation:
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (SharedPreferenceWriter.getInstance(Splash.this).
                        getString(SharedPreferenceKey.currentLogin).equalsIgnoreCase("true")) {
                    //go to homepage
                    startActivity(new Intent(Splash.this, TeamPageHome.class));
                    finish();
                } else {
                    //go to login page
                    startActivity(new Intent(Splash.this, HomeLoginAll.class));
                    finish();
                }

            }
        }, 2000);
    }
}


