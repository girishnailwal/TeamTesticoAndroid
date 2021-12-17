package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityProfileCoachBinding;
import com.teamtasticoapp.databinding.PopDeleteOnlyCoachBinding;
import com.teamtasticoapp.databinding.PopupDeleteBinding;
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

public class ProfileCoach extends BaseActivity implements View.OnClickListener {
    ActivityProfileCoachBinding binding;
    String getUserName, getForward, getGmail, getTeamName, getTeamCode, getUserImage;
    String Authorization = "";
    private String getDeviceId = "";
    String getUserId = "";
    String getType = "";
    String teamName = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_coach);


        binding.ivCoach.setOnClickListener(this);
        binding.ivEdtCoach.setOnClickListener(this);
       // binding.btnContactList.setOnClickListener(this);
        binding.llDeleteTeam.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
        binding.llLogOutTeam.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ProfileCoach.this.finish();
    }

    public boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) this

                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            Log.e("Network Testing", "***Available***");

            return true;

        }

        Log.e("Network Testing", "***Not Available***");

        return false;

    }

    @Override
    protected void onResume() {
        super.onResume();

        teamName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_name);
        Log.i("TeamName", "teamname" + teamName);

        if (isNetworkAvailable() == true) {

            getProfileDataApi();

        } else {
            Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
        }

    }


    private void getProfileDataApi() {
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));

        Call<CommonResponse> call = apiInterface.getProfileResult(map);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,

                        AllResponse allResponse = response.body().getAllResponse();

                        getUserImage = allResponse.getImage();
                        if (!getUserImage.isEmpty() && getUserImage != null) {
                            /*AQuery aQuery = new AQuery(ProfileCoach.this);
                            aQuery.id(binding.ivCoach).image(getUserImage, false, false, 0, R.drawable.profile_pic);*/

                            Picasso.with(ProfileCoach.this).load(getUserImage).into(binding.ivCoach);
                        }

                        getUserName = allResponse.getName();
                        if (!getUserName.isEmpty()) {
                            binding.tvUserName.setText(getUserName);

                        }
                        getGmail = allResponse.getEmail();
                        if (!getGmail.isEmpty()) {
                            binding.tvGmail.setText(getGmail);
                        }

                        getForward = allResponse.getPosition();
                        if (!getForward.isEmpty()) {
                            binding.tvForward.setText(getForward);
                        }

                        getTeamName = allResponse.getTeam_name();
                        if (!getTeamName.isEmpty()) {
                            binding.tvTeamName.setText(getTeamName);
                        }

                        getTeamCode = allResponse.getTeam_code();
                        if (!getTeamCode.isEmpty()) {
                            binding.tvTeamCode.setVisibility(View.VISIBLE);
                            binding.tvTeamCode.setText(getTeamCode);
                            binding.tvTeamCode.setTextIsSelectable(true);
                        }

                        getType = allResponse.getType();


                    } else {
                        Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else if (response.message().equalsIgnoreCase("Unauthorized")) {
                    Intent intent = new Intent(ProfileCoach.this, HomeLoginAll.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    SharedPreferenceWriter.getInstance(ProfileCoach.this).writeStringValue(SharedPreferenceKey.currentLogin, "false");
                    startActivity(intent);
                    ProfileCoach.this.finishAffinity();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == binding.ivCoach || view == binding.ivEdtCoach) {
            Intent intent = new Intent(ProfileCoach.this, EditProfile.class);

            Bundle bundle = new Bundle();

            bundle.putString("getGmail", getGmail);
            bundle.putString("getUserName", getUserName);
            bundle.putString("getForward", getForward);
            bundle.putString("getImage", getUserImage);
            bundle.putInt("type", 1);// type 1 for coach and type 2 for player

            intent.putExtras(bundle);

            startActivity(intent);


       /* } else if (view == binding.btnContactList) {
            Intent intent = new Intent(this, InviteFriends.class);
            startActivity(intent);*/

        } else if (view == binding.llDeleteTeam) {
            callCheckPlayerListApi();

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(ProfileCoach.this, AboutUs.class);
            startActivity(intent);

        } else if (view == binding.llTeam) {
            Intent intent = new Intent(ProfileCoach.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {
            Intent intent = new Intent(this, TeamPageHome.class);

            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);

            startActivity(intent);

        } else if (view == binding.llLogOutTeam) {
            callLogoutApi();
           /* Intent intent = new Intent(this, HomeLoginAll.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            SharedPreferenceWriter.getInstance(ProfileCoach.this).writeBooleanValue(SharedPreferenceKey.currentLogin, false);
            startActivity(intent);

            this.finish();
            if (TeamPageHome.instance!=null) {
                TeamPageHome.instance.finish();
            }*/

        }
    }

    private void callCheckPlayerListApi() {

        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));

        Call<CommonResponse> call = apiInterface.getPlayerListResult(map);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //to get all response here,
                        openDeletePopUpBySelectAnotherPlayerAsCoachFirst();

                    } else {
                        openDeleteCoachOnlyPopup();
                    }
                } else {
                    //To see server error in logcat
                    Toast.makeText(ProfileCoach.this, "server error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
                t.printStackTrace();

            }
        });

    }


    private void openDeletePopUpBySelectAnotherPlayerAsCoachFirst() {

        PopupDeleteBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.popup_delete, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);


        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                startActivity(new Intent(ProfileCoach.this, DeleteCoach.class));

            }
        });

        dialog.show();

    }


    private void openDeleteCoachOnlyPopup() {
        PopDeleteOnlyCoachBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.pop_delete_only_coach, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                callDeleteOnlyCoachApi();

            }
        });
        binding.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    private void callDeleteOnlyCoachApi() {

        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));

        Call<CommonResponse> call = apiInterface.getDeleteCoachResult(map, "");

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,
                        Intent intent = new Intent(ProfileCoach.this, HomeLoginAll.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        ProfileCoach.this.finishAffinity();

                    } else {
                        Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
            }
        });
    }


    private void callLogoutApi() {

        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        getDeviceId = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_id);

        Call<CommonResponse> call = apiInterface.getLogoutResult(map, getDeviceId, "android");

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {


                        Intent intent = new Intent(ProfileCoach.this, HomeLoginAll.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        SharedPreferenceWriter.getInstance(ProfileCoach.this).writeStringValue(SharedPreferenceKey.currentLogin, "false");

                      /*  for(int i=0;i<11;i++){
                            SharedPreferenceWriter.getInstance(getApplication()).writeStringValue("p"+i,"");
                        }*/

                        startActivity(intent);

                        ProfileCoach.this.finish();
                        if (TeamPageHome.instance != null) {
                            TeamPageHome.instance.finish();
                        }
                        Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ProfileCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileCoach.this).hideDialog();
            }
        });
    }


}

