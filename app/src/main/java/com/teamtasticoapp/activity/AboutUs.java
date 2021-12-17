package com.teamtasticoapp.activity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityAboutUsBinding;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

import java.util.List;

/**
 * Created by mobulous55 on 8/3/18.
 */

public class AboutUs extends BaseActivity implements View.OnClickListener {
    ActivityAboutUsBinding binding;
    String getType = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_us);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        binding.llMail.setOnClickListener(this);
        // binding.llMessage.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AboutUs.this.finishAffinity();
    }

    @Override
    public void onClick(View view) {
        if (view == binding.llMail) {
            Intent mailer = new Intent(Intent.ACTION_SEND);
            mailer.setType("message/rfc822");
            //mailer.setType("text/plain");
            mailer.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@teamtastico.com"});
            mailer.putExtra(Intent.EXTRA_SUBJECT, "");
            mailer.putExtra(Intent.EXTRA_TEXT, "");
            mailer.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(mailer, "Send email..."));

        } else if (view == binding.llProfile) {

            if (!getType.isEmpty()) {
                switch (getType) {

                    case "Coach":
                    case "coach":
                        Intent intent = new Intent(this, ProfileCoach.class);
                        startActivity(intent);
                        break;

                    case "Player":
                    case "player":
                        startActivity(new Intent(this, ProfileTeamPlayer.class));
                        break;

                    default:
                        break;
                }
            } else {
                Toast.makeText(this, "Create Profile First", Toast.LENGTH_SHORT).show();
            }


        } else if (view == binding.llTeam) {
            String isLogin = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.currentLogin);
            if (isLogin.equalsIgnoreCase("true")) {
                Intent intent = new Intent(AboutUs.this, TeamPageHome.class);
                startActivity(intent);
            } else if (!getType.isEmpty()) {
                Intent intent = new Intent(AboutUs.this, TeamPageHome.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Create Profile First", Toast.LENGTH_SHORT).show();
            }


        } else if (view == binding.llChat) {
            String isLogin = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.currentLogin);
            if (isLogin.equalsIgnoreCase("true")) {
                Intent intent = new Intent(AboutUs.this, TeamPageHome.class);
                Bundle bundle = new Bundle();
                bundle.putString("from", "profile");
                intent.putExtras(bundle);
                startActivity(intent);
            } else if (!getType.isEmpty()) {
                Intent intent = new Intent(AboutUs.this, TeamPageHome.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Create Profile First", Toast.LENGTH_SHORT).show();
            }


       /* } else if (view == binding.llMessage) {
            openInbox();*/
        }
    }

   /* private void openInbox() {

        String application_name = "com.android.mms";
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");

            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            List<ResolveInfo> resolveinfo_list = this.getPackageManager()
                    .queryIntentActivities(intent, 0);

            for (ResolveInfo info : resolveinfo_list) {
                if (info.activityInfo.packageName
                        .equalsIgnoreCase(application_name)) {
                    launchComponent(info.activityInfo.packageName,
                            info.activityInfo.name);
                    break;
                }
            }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(
                    this.getApplicationContext(),
                    "There was a problem loading the application: "
                            + application_name, Toast.LENGTH_SHORT).show();
        }
    }*/


   /* private void launchComponent(String packageName, String name) {
        Intent launch_intent = new Intent("android.intent.action.MAIN");
        launch_intent.addCategory("android.intent.category.LAUNCHER");
        launch_intent.setComponent(new ComponentName(packageName, name));
        launch_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(launch_intent);
    }*/
}
