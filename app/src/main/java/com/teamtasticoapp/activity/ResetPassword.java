package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.databinding.ActivityResetPassBinding;
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
 * Created by mobulous55 on 16/5/18.
 */

public class ResetPassword extends BaseActivity implements View.OnClickListener {
    ActivityResetPassBinding binding;

    String newPass = "";
    String confirmPass = "";
    String email = "";
    String pass = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_pass);
        email = getIntent().getStringExtra("edtEmail");

        binding.btnChangePassword.setOnClickListener(this);
        binding.ivBackButton.setOnClickListener(this);

    }


    private boolean validateForm() {
        boolean flag = true;

        newPass = binding.edtNewPass.getText().toString().trim();
        confirmPass = binding.edtConfirmPass.getText().toString().trim();

        if (newPass.length() == 0) {
            Toast.makeText(ResetPassword.this, "Please Enter New Password", Toast.LENGTH_LONG).show();
            return false;
        } else if (newPass.length() < 8 && newPass.length() >= 20) {
            Toast.makeText(ResetPassword.this, "Password Should Not More Than 20 Character", Toast.LENGTH_LONG).show();
            return false;
        } else if (confirmPass.length() == 0) {
            Toast.makeText(ResetPassword.this, "Please Enter Confirm Password", Toast.LENGTH_LONG).show();
            return false;
        } else if (confirmPass.length() < 8 && confirmPass.length() >= 20) {
            Toast.makeText(ResetPassword.this, "Password Should Not More Than 20 Character", Toast.LENGTH_LONG).show();
            return false;
        }
        return flag;

    }


    @Override
    public void onClick(View view) {
        if (view == binding.btnChangePassword) {
            if (validateForm()) {

                if (newPass.equals(confirmPass)) {
                    pass = newPass;
                }else {
                    Toast.makeText(this, "password is not matching", Toast.LENGTH_SHORT).show();
                }
                callChangePasswordOtpApi(email,pass);
            }

        } else if (view == binding.ivBackButton) {
            ResetPassword.this.finish();
        }
    }

    private void callChangePasswordOtpApi(String email, String pass) {

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<CommonResponse> call = apiInterface.getChangePasswordOtpResult(email, pass);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ResetPassword.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(ResetPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ResetPassword.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(ResetPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ResetPassword.this).hideDialog();
            }
        });

    }
}
