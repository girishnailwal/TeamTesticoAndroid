package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityJoinTeamConfirmationBinding;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

/**
 * Created by mobulous55 on 15/2/18.
 */

public class JoinTeamConfirmation extends BaseActivity implements View.OnClickListener {
    ActivityJoinTeamConfirmationBinding binding;
    String getTeamName, getPlayerName, getTeamCode, getEdtName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join_team_confirmation);

        getTeamName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_name);
        getPlayerName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.name);
        getTeamCode = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_code);

        getEdtName = getIntent().getStringExtra("NAME");
        binding.tvJoinTeamConfirmTitle.setText(getTeamName);

        binding.tvPlayerName.setText(getEdtName);
        binding.tvTeamName.setText(getTeamName);
        binding.tvTeamCode.setText(getTeamCode);
        binding.tvTeamCode.setTextIsSelectable(true);

        binding.visitTeamPages.setOnClickListener(this);
        //binding.contactLists.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == binding.visitTeamPages) {
            Intent intent = new Intent(this, TeamPageHome.class);
            startActivity(intent);

        /*} else if (view == binding.contactLists) {
            Intent intent = new Intent(this, InviteFriends.class);
            startActivity(intent);*/

        } else if (view == binding.llProfile) {
            Intent intent = new Intent(this, ProfileTeamPlayer.class);
            startActivity(intent);

        }else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        JoinTeamConfirmation.this.finishAffinity();

    }
}

