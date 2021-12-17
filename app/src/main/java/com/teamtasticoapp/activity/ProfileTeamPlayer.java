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
import com.teamtasticoapp.databinding.ActivityProfileTeamPlayerBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBinding;
import com.teamtasticoapp.databinding.PopupWantToLeaveBinding;
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

public class ProfileTeamPlayer extends BaseActivity implements View.OnClickListener {
    ActivityProfileTeamPlayerBinding binding;

    public final String TAG= ProfileTeamPlayer.class.getSimpleName();

    String getUserName, getForward, getGmail, getTeamName, getTeamCode, getUserImage;
    String Authorization = "";
    private String getDeviceId = "";
    String teamName = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_team_player);

        binding.ivPlayer.setOnClickListener(this);
        binding.ivEdtPlayer.setOnClickListener(this);
        // binding.btnContactList.setOnClickListener(this);
        binding.llLeaveTeam.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
        binding.llLogOutTeam.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);
        binding.llDeletePlayer.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ProfileTeamPlayer.this.finish();
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

            getPlayerProfileDataApi();

        } else {
            Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
        }
    }

    private void getPlayerProfileDataApi() {

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
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,

                        AllResponse allResponse = response.body().getAllResponse();

                        getUserImage = allResponse.getImage();
                        if (!getUserImage.isEmpty() && getUserImage != null) {
                            /*AQuery aQuery = new AQuery(ProfileTeamPlayer.this);
                            aQuery.id(binding.ivPlayer).image(getUserImage, false, false, 0, R.drawable.profile_pic);*/

                            Picasso.with(ProfileTeamPlayer.this).load(getUserImage).into(binding.ivPlayer);
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

                        SharedPreferenceWriter.getInstance(ProfileTeamPlayer.this).writeStringValue(SharedPreferenceKey.team_name, getTeamName);

                    } else {
                        Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.message().equalsIgnoreCase("Unauthorized")) {
                    Intent intent = new Intent(ProfileTeamPlayer.this, HomeLoginAll.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    SharedPreferenceWriter.getInstance(ProfileTeamPlayer.this).writeStringValue(SharedPreferenceKey.currentLogin, "false");
                    startActivity(intent);
                    ProfileTeamPlayer.this.finishAffinity();
                }

            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.llLeaveTeam) {
            openLeaveTeamPopup();

        } else if (view == binding.ivPlayer || view == binding.ivEdtPlayer) {
            Intent intent = new Intent(ProfileTeamPlayer.this, EditProfile.class);

            Bundle bundle = new Bundle();

            bundle.putString("getGmail", getGmail);
            bundle.putString("getUserName", getUserName);
            bundle.putString("getForward", getForward);
            bundle.putString("getImage", getUserImage);
            bundle.putInt("type", 2); //type 2 for player and 1 for coach

            intent.putExtras(bundle);

            startActivity(intent);


       /* } else if (view == binding.btnContactList) {
            Intent intent = new Intent(this, InviteFriends.class);
            startActivity(intent);*/

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        } else if (view == binding.llTeam) {
            Intent intent = new Intent(ProfileTeamPlayer.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {

            Intent intent = new Intent(ProfileTeamPlayer.this, TeamPageHome.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (view == binding.llLogOutTeam) {
            callLogoutApi();

        }else if(view==binding.llDeletePlayer){
            openWantToDeletePlayerPopup();
        }

    }

    private void openWantToDeletePlayerPopup() {

        PopupWantToDeleteBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.popup_want_to_delete, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.txtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                callDeletePlayerApi();

            }
        });

        binding.txtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void callDeletePlayerApi() {
        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getDeletePlayerResult(map);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfileTeamPlayer.this, HomeLoginAll.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        ProfileTeamPlayer.this.finishAffinity();

                    } else {
                        Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
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
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {

                        Intent intent = new Intent(ProfileTeamPlayer.this, HomeLoginAll.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        SharedPreferenceWriter.getInstance(ProfileTeamPlayer.this).writeStringValue(SharedPreferenceKey.currentLogin, "false");
                        startActivity(intent);

                        ProfileTeamPlayer.this.finish();
                        if (TeamPageHome.instance != null) {
                            TeamPageHome.instance.finish();
                        }
                        Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ProfileTeamPlayer.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ProfileTeamPlayer.this).hideDialog();
            }
        });

    }



    private void openLeaveTeamPopup() {
        PopupWantToLeaveBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.popup_want_to_leave, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.txtYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //leave current team and join other team using enter team code below
                Intent intent = new Intent(ProfileTeamPlayer.this, LeaveTeam.class);

                Bundle bundle = new Bundle();
                bundle.putString("teamName", teamName);
                bundle.putString("getGmail", getGmail);
                bundle.putString("getUserName", getUserName);
                bundle.putString("getForward", getForward);
                bundle.putString("getImage", getUserImage);
                bundle.putInt("type", 2); //type 2 for player and 1 for coach

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        binding.txtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
