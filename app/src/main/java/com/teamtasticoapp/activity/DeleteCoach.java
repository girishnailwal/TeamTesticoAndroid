package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityDeleteCoachBinding;
import com.teamtasticoapp.databinding.PopupDeleteProceedBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteBinding;
import com.teamtasticoapp.adapter.DeleteCoachAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.TeamMemberResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by mobulous55 on 5/3/18.
 */

public class DeleteCoach extends BaseActivity implements View.OnClickListener {
    ActivityDeleteCoachBinding binding;

    List<TeamMemberResponse> teamList = new ArrayList<>();
    DeleteCoachAdapter adapter;
    String Authorization = "";
    String getType = "";
    private String userId="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_delete_coach);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        if (isNetworkAvailable() == true) {

            callTeamListApi();

        } else {
            Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
        }

        binding.llAboutUs.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        DeleteCoach.this.finishAffinity();
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

    private void callTeamListApi() {
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        JSONObject jsonObject = new JSONObject();
//        try {
//            String token = Authorization;
//
//            jsonObject.put("Authorization", token);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));

//        RequestBody body = RequestBody
//                .create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Call<CommonResponse> call = apiInterface.getTeamListResult(map);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(DeleteCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,
                        if (response.body().getAllResponse().getTeamMemberResponseList() != null &&
                                response.body().getAllResponse().getTeamMemberResponseList().size() > 0) {

                            teamList.clear();
                            teamList.addAll(response.body().getAllResponse().getTeamMemberResponseList());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DeleteCoach.this);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.rvContactlist.setLayoutManager(linearLayoutManager);

                            adapter = new DeleteCoachAdapter(DeleteCoach.this, teamList);
                            binding.rvContactlist.setAdapter(adapter);

                            adapter.setOnContactItemClickListener(new DeleteCoachAdapter.OnContactItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    TeamMemberResponse teamMemberResponse = teamList.get(pos);

                                    String name = teamMemberResponse.getName();
                                    userId = teamMemberResponse.getUser_id();

                                    // SharedPreferenceWriter.getInstance(DeleteCoach.this).writeStringValue(SharedPreferenceKey.user_id, userId);
                                    // Toast.makeText(DeleteCoach.this, name + "is new coach!!", Toast.LENGTH_SHORT).show();
                                    openDeleteProceedPopup(name);

                                }
                            });


                        } else {

                            // Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(DeleteCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(DeleteCoach.this).hideDialog();
            }
        });
    }

    private void openDeleteProceedPopup(String name) {
        PopupDeleteProceedBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.popup_delete_proceed, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        // Toast.makeText(DeleteCoach.this, name + "is new coach!!", Toast.LENGTH_SHORT).show();
        // binding.tvName.setText(name + " is new coach!!");
        binding.tvName.setText(name + "");

        binding.btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                openWantToDeletePopup();
            }
        });

        dialog.show();

    }

    private void openWantToDeletePopup() {
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
                callDeleteCoachApi();
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

    private void callDeleteCoachApi() {

        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);
        //getUserId = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.user_id);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));

        Call<CommonResponse> call = apiInterface.getDeleteCoachResult(map, userId);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(DeleteCoach.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //to get all response here,

                        Toast.makeText(DeleteCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DeleteCoach.this, HomeLoginAll.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        DeleteCoach.this.finishAffinity();

                    } else {
                        Toast.makeText(DeleteCoach.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(DeleteCoach.this).hideDialog();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        }else if (view == binding.llProfile) {

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
            Intent intent = new Intent(DeleteCoach.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {
            Intent intent = new Intent(DeleteCoach.this, TeamPageHome.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}

