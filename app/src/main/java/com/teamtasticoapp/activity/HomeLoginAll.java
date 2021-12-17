package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityHomeLoginAllBinding;

/**
 * Created by mobulous55 on 12/2/18.
 */

public class HomeLoginAll extends BaseActivity implements View.OnClickListener {
    ActivityHomeLoginAllBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_login_all);

        binding.createTeam.setOnClickListener(this);
        binding.joinTeam.setOnClickListener(this);
        binding.tvLogin.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HomeLoginAll.this.finishAffinity();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_team:
                Intent intent = new Intent(HomeLoginAll.this, CreateTeam.class);
                startActivity(intent);
                break;

            case R.id.join_team:
                Intent intent1 = new Intent(HomeLoginAll.this, JoinTeam.class);
                startActivity(intent1);
                break;

            case R.id.tvLogin:
                Intent intent2 = new Intent(HomeLoginAll.this, Login.class);
                startActivity(intent2);
                break;

        }
    }

}
