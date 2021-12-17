package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityChangePasswordBinding;
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
 * Created by Dev-PC on 3/4/2018.
 */

public class ChangePassword extends BaseActivity implements View.OnClickListener {
    ActivityChangePasswordBinding binding;

    String Authorization = "";
    String oldPwd = "";
    String newPwd = "";
    String getType = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        binding.btnChangePassword.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);

    }

    private boolean validateForm() {
        boolean flag = true;

        oldPwd = binding.edtOldPwd.getText().toString().trim();
        newPwd = binding.edtNewPwd.getText().toString().trim();

        if (oldPwd.length() == 0) {
            Toast.makeText(ChangePassword.this, "Please Enter Old Password", Toast.LENGTH_LONG).show();
            return false;
        } else if (oldPwd.length() < 8 && oldPwd.length() >= 20) {
            Toast.makeText(ChangePassword.this, "Password Should Not More Than 20 Character", Toast.LENGTH_LONG).show();
            return false;
        } else if (newPwd.length() == 0) {
            Toast.makeText(ChangePassword.this, "Please Enter New Password", Toast.LENGTH_LONG).show();
            return false;
        } else if (newPwd.length() < 8 && newPwd.length() >= 20) {
            Toast.makeText(ChangePassword.this, "Password Should Not More Than 20 Character", Toast.LENGTH_LONG).show();
            return false;
        }
        return flag;

    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnChangePassword) {
            if (validateForm()) {
                callChangePasswordApi();
            }
        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
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
            }
        }

    }

    private void callChangePasswordApi() {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getChangePasswordResult(map, oldPwd, newPwd);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ChangePassword.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(ChangePassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,
                        ChangePassword.this.finish();

                    } else {
                        Toast.makeText(ChangePassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ChangePassword.this).hideDialog();
            }
        });


    }
}
