package com.teamtasticoapp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityAllUserFloatingMenuBinding;
import com.teamtasticoapp.adapter.UserListAdapter;
import com.teamtasticoapp.bean.UserListModel;
import com.teamtasticoapp.bean.UserListResponse;
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
 * Created by mobulous55 on 13/3/18.
 */

public class AllUserFloatingActionMenuActivity extends BaseActivity implements View.OnClickListener {
    ActivityAllUserFloatingMenuBinding binding;
    List<UserListResponse> userList = new ArrayList<>();
    UserListAdapter userListAdapter;
    String Authorization = "";
    String getType = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_user_floating_menu);

        binding.llProfile.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);
        binding.llBack.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        if (isNetworkAvailable() == true) {

            callAllUserListApi();

        } else {
            Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
        }
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

    private void callAllUserListApi() {

        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<UserListModel> call = apiInterface.getUserListResult(map);

        call.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                MyDialog.getInstance(AllUserFloatingActionMenuActivity.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        //to get all response here,

                        userList.clear();

                        if (response.body().getUserListResponses() != null &&
                                response.body().getUserListResponses().size() > 0) {

                            userList.addAll(response.body().getUserListResponses());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AllUserFloatingActionMenuActivity.this);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerViewAllContactlist.setLayoutManager(linearLayoutManager);

                            userListAdapter = new UserListAdapter(AllUserFloatingActionMenuActivity.this, userList);
                            binding.recyclerViewAllContactlist.setAdapter(userListAdapter);

                            userListAdapter.setOnAllContactItemClickListener(new UserListAdapter.OnAllContactItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    UserListResponse userListResponse = userList.get(pos);

                                    Intent intent = new Intent(AllUserFloatingActionMenuActivity.this, IndividualChatDetail.class);
                                    intent.putExtra("name", userListResponse.getName());
                                    intent.putExtra("chatId", userListResponse.getChat_id());
                                    intent.putExtra("receiverId", userListResponse.getUser_id());

                                    startActivity(intent);

                                }
                            });
                        } else {

                            // Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        // Toast.makeText(AllUserFloatingActionMenuActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                MyDialog.getInstance(AllUserFloatingActionMenuActivity.this).hideDialog();
            }

        });

    }


    @Override
    public void onClick(View view) {
        if (view == binding.llProfile) {
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

        } else if (view == binding.llBack) {
            finish();

        } else if (view == binding.llTeam) {
            Intent intent = new Intent(AllUserFloatingActionMenuActivity.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {
            Intent intent = new Intent(AllUserFloatingActionMenuActivity.this, TeamPageHome.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}









