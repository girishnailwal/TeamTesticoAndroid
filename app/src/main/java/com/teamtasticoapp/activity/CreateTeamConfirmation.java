package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityCreateTeamConfirmationBinding;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class CreateTeamConfirmation extends BaseActivity implements View.OnClickListener {
    ActivityCreateTeamConfirmationBinding binding;

    String getTeamName="";
    String getTeamCode="";
    String getEdtName = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_team_confirmation);

        getTeamName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_name);
        getTeamCode = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_code);

        binding.tvCreateTeamConfirmTitle.setText(getTeamName);
        binding.tvTeamName.setText(getTeamName);
        binding.tvTeamCode.setText(getTeamCode);
        binding.tvTeamCode.setTextIsSelectable(true);

        getEdtName = getIntent().getStringExtra("NAME");
        binding.tvName.setText(getEdtName);

        binding.visitTeamPage.setOnClickListener(this);
        //binding.contactList.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == binding.visitTeamPage) {
            Intent intent = new Intent(this, TeamPageHome.class);
            startActivity(intent);

       /* } else if (view == binding.contactList) {
            Intent intent = new Intent(this, InviteFriends.class);
            startActivity(intent);*/

        } else if (view == binding.llProfile) {
            Intent intent = new Intent(this, ProfileCoach.class);
            startActivity(intent);

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        CreateTeamConfirmation.this.finishAffinity();//to finish from all activities

    }

}
