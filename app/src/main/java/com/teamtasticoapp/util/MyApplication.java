package com.teamtasticoapp.util;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by mobulous55 on 28/2/18.
 */
public class MyApplication extends MultiDexApplication {

    private static MyApplication myApplication = null;


    @Override
    public void onCreate() {
        try {

            super.onCreate();

            myApplication = this;

        } catch (NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }

    public static synchronized MyApplication getInstance() {
        if (myApplication == null) {
            return new MyApplication();
        } else
            return myApplication;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    // METHOD: TO SHOW FAILURE MESSAGES ,Used IN RETROFIT SERVICE CALL onFailure() Method
    public static void showOnFailureMessages(Context context, Throwable t) {
        if (context != null) {
            if (t instanceof UnknownHostException)
                Toast.makeText(context, "Internet not available", Toast.LENGTH_SHORT).show();
            else if (t instanceof SocketTimeoutException)
                Toast.makeText(context, "Internet is slow! Try again", Toast.LENGTH_SHORT).show();
            else if (t instanceof ConnectException)
                Toast.makeText(context, "Failed to connect to Server!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }

    }

    // METHOD: TO HIDE SOFT INPUT KEYBOARD
    public static void hideSoftKeyBoard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getCurrentFocus() != null)
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);

    }


    // new change
    @NonNull
    public static String removeAllSpacesInBwFromMob(String str, String TAG) {
        str = str.replace(" ", "");

        String builder = str.trim();

        Log.w(TAG, "removeAllSpacesInBwFrom Mob Number:->" + builder + "<-\n");

        return builder.trim();
    }


}




