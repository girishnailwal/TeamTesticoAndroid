package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityLeaveTeamBinding;
import com.teamtasticoapp.bean.AllResponse;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 15/2/18.
 */

public class LeaveTeam extends BaseActivity implements View.OnClickListener {
    ActivityLeaveTeamBinding binding;
    String edtTeamCode = "";
    String Authorization = "";

    private String email = "";
    private String name = "";
    private String position = "";
    private String image = "";
    private int mType;
    String getTeamName = "";
    String getType = "";
    String teamId = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_leave_team);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        Bundle bundle = getIntent().getExtras();

        getTeamName = bundle.getString("teamName");
        email = bundle.getString("getGmail");
        name = bundle.getString("getUserName");
        position = bundle.getString("getForward");
        image = bundle.getString("getImage");
        mType = bundle.getInt("type", 0);

        binding.tvUserName.setText(name);
        binding.tvUserPosition.setText(position);
        binding.tvUserEmail.setText(email);
        binding.tvTeamName.setText(getTeamName);

        if (!image.equals("")) {
           /* AQuery aQuery = new AQuery(LeaveTeam.this);
            aQuery.id(binding.ivPlayer).image(image, false, false, 0, R.drawable.profile_pic);*/

            Picasso.with(LeaveTeam.this).load(image).into(binding.ivPlayer);
        }

        binding.btnNext.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LeaveTeam.this.finish();
    }

    private boolean validateForm() {
        boolean validate = true;
        edtTeamCode = binding.edtTeamCode.getText().toString().trim();

        if (edtTeamCode.isEmpty() && edtTeamCode.equals("")) {
            Toast.makeText(this, "Please Enter valid Team Code", Toast.LENGTH_SHORT).show();
            return false;
        }
        return validate;
    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnNext) {
            if (validateForm()) {
                callCheckTeamCodeApi();
            }

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(LeaveTeam.this, AboutUs.class);
            startActivity(intent);

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
                Toast.makeText(this, "Type Empty", Toast.LENGTH_SHORT).show();
            }


        } else if (view == binding.llTeam) {
            Intent intent = new Intent(LeaveTeam.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {
            Intent intent = new Intent(LeaveTeam.this, TeamPageHome.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    private void callCheckTeamCodeApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getCheckTeamCodeResult(edtTeamCode);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(LeaveTeam.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(LeaveTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        AllResponse allResponse = response.body().getAllResponse();
                        teamId = allResponse.getTeam_id();

                        callLeaveTeamApi();
                    } else {
                        Toast.makeText(LeaveTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(LeaveTeam.this).hideDialog();
            }
        });
    }

    private void callLeaveTeamApi() {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getLeavePlayerResult(map, teamId);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(LeaveTeam.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //to get all response here,
                        Toast.makeText(LeaveTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        LeaveTeam.this.finish();//to finish from current activity
                    } else {
                        Toast.makeText(LeaveTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(LeaveTeam.this).hideDialog();
            }
        });

    }


}


