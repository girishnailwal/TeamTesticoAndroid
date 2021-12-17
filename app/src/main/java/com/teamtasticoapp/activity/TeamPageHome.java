package com.teamtasticoapp.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityTeamPageHomeBinding;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.fragment.ChatFragment;
import com.teamtasticoapp.fragment.TeamLineupScheduleFragment;
import com.teamtasticoapp.fragment.TeamListFragment;

/**
 * Created by Dev-PC on 2/17/2018.
 */

public class TeamPageHome extends BaseActivity implements View.OnClickListener {
    ActivityTeamPageHomeBinding binding;
    public static TeamPageHome instance;
    String getTeamName = "";
    String getType = "";
    private String from = "";
    private Bundle bundle = null;
    private boolean isFirstFragment;//by default boolean false;
    String mTeamName = "";

    private final String TAG = TeamPageHome.class.getSimpleName();//it's value never been changed bcz final

    public static boolean isTeamHomeOnForeground = false;

    //called when activity is first created.
    //The onCreate() and onDestroy() methods are called only once throughout the activity lifecycle.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_page_home);

        instance = this;
        isTeamHomeOnForeground = true;

        clickListener();

        //to receive data from an activity
        if (getIntent() != null) {
            bundle = getIntent().getExtras();

            if (bundle != null) {
                //to receive data(here,String) from an activity on this key "from"
                String from = bundle.getString("from");
                Log.w(TAG, "from: " + from);

                if ("fcm".equalsIgnoreCase(from)) {
                    displayFragment(1);
                } else if ("profile".equalsIgnoreCase(from)) {
                    displayFragment(1);
                }
            } else {
                displayFragment(0);
            }
        } else {
            displayFragment(0);
        }


    }


    BroadcastReceiver pushChatBReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle bundle = intent.getExtras();
        }
    };

    private void clickListener() {
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        // binding.llMessage.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);

    }


    //called when activity will start interacting with the user.
    @Override
    protected void onResume() {
        super.onResume();

        isTeamHomeOnForeground = true;

        getTeamName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_name);
        binding.tvFragmentListTitle.setText(getTeamName);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        // REGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(TeamPageHome.this).registerReceiver(pushChatBReceiver,
                new IntentFilter("PUSH_CHAT"));

    }

    //called when activity is no longer visible to the user.
    @Override
    protected void onStop() {
        super.onStop();
        isTeamHomeOnForeground = false;

        // UNREGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(TeamPageHome.this).unregisterReceiver(pushChatBReceiver);
    }

    //called before the activity is destroyed.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isTeamHomeOnForeground = false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llTeam:
                binding.topBarLayout.setVisibility(View.VISIBLE);
                displayFragment(0);
                break;

            case R.id.llChat:
                binding.topBarLayout.setVisibility(View.VISIBLE);
                displayFragment(1);
                break;

            /*case R.id.llMessage:
                binding.topBarLayout.setVisibility(View.VISIBLE);
                displayFragment(2);
                break;*/

            case R.id.llProfile:

                if (!getType.isEmpty()) {
                    switch (getType) {

                        case "Coach":
                        case "coach":
                            Intent intent1 = new Intent(this, ProfileCoach.class);
                            startActivity(intent1);
                            break;

                        case "Player":
                        case "player":
                            Intent intent2 = new Intent(this, ProfileTeamPlayer.class);
                            startActivity(intent2);
                            break;

                        default:
                            break;

                    }
                } else {
                    Toast.makeText(this, "Type Empty", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.llAboutUs:

                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);

        }

    }

    private void displayFragment(int position) {


        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                isFirstFragment = true;
                //fragment = new TeamListFragment();
                fragment = new TeamLineupScheduleFragment();
                title = getString(R.string.app_name);
                binding.ivTeam.setImageResource(R.drawable.team_s);
                binding.ivChat.setImageResource(R.drawable.xhat_un);

                // binding.ivMessage.setImageResource(R.drawable.message_un);
                break;

            case 1:
                isFirstFragment = false;
                fragment = new ChatFragment();
                title = getString(R.string.app_name);
                binding.ivChat.setImageResource(R.drawable.xhat_s);
                binding.ivTeam.setImageResource(R.drawable.team_un);

                // binding.ivMessage.setImageResource(R.drawable.message_un);
                break;

          /*case 2:
                fragment = new MessageFragment();
                title = getString(R.string.app_name);
                binding.ivMessage.setImageResource(R.drawable.message_s);
                binding.ivTeam.setImageResource(R.drawable.team_un);
                binding.ivChat.setImageResource(R.drawable.xhat_un);
                break;*/

            // The java switch statement is fall-through.
            // It means it executes all statement after first match
            // if break statement is not used with switch cases.
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Using with fragment transaction. we can move one fragment to another fragment.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            if (bundle != null)
                //to send data to a fragment from an activity, setArguments(bundle) to supply the
                //construction arguments for the Fragment.
                fragment.setArguments(bundle);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onBackPressed() {
        if (isFirstFragment == false) {
            isFirstFragment = true;
            displayFragment(0);

        } else {
            super.onBackPressed();
            TeamPageHome.this.finishAffinity();
        }

    }
}
