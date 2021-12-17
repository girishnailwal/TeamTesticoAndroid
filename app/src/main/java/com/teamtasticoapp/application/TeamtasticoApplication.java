package com.teamtasticoapp.application;

import android.app.Activity;
import android.app.Application;

import com.flurry.android.FlurryAgent;

import static android.util.Log.VERBOSE;

/**
 * Created by junaid on 10/31/2017.
 */

public class TeamtasticoApplication extends Application {
    static TeamtasticoApplication instance;//declare variable of class TeamtasticoApplication

    public TeamtasticoApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = new TeamtasticoApplication();//if we create new instance below then don't need to write here
                                                //only need to write here, instance = this;

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .withCaptureUncaughtExceptions(true)
                .withContinueSessionMillis(10)
                .withLogLevel(VERBOSE)
                .build(this, "RJ6R59QDHRB626ZFGT3Z");

    }

    //singleton class,means creating one object only

    //getInstance() method of class TeamtasticoApplication,created by using alt+insert getter method
    //this static method is called from anywhere in an application to provide global access to methods or variables.
    //using class name dot method name or variable name.
    public static TeamtasticoApplication getInstance() {
        //if instance is not null/empty it means instance is available so,it returns instance itself
        if (instance != null)
            return instance;
        else
            //if instance is null/empty it means instance is not available
            //so,it create new instance and returns instance.
            return instance = new TeamtasticoApplication();
    }


    private Activity mCurrentActivity = null;
    private boolean activityVisible;

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }

    public boolean isVisible() {
        return activityVisible;
    }

    public void setVisible(Boolean activityVisible) {
        this.activityVisible = activityVisible;
    }
}
