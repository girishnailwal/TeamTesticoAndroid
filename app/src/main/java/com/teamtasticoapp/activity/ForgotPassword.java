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

import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.AllResponse;
import com.teamtasticoapp.databinding.ActivityForgotPasswordBinding;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.databinding.OtpdailogueBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBinding;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 16/2/18.
 */

public class ForgotPassword extends BaseActivity implements View.OnClickListener {
    ActivityForgotPasswordBinding binding;
    String edtEmail = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);

        binding.submit.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this);
    }

    private boolean validateForm() {
        boolean validate = true;
        edtEmail = binding.email.getText().toString().trim();

        if (edtEmail.length() == 0) {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Utility.isValidEmail(edtEmail)) {
            Toast.makeText(ForgotPassword.this, "Please Enter Valid Email", Toast.LENGTH_LONG).show();
            return false;
        }
        return validate;
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
    public void onClick(View view) {
        if (view == binding.submit) {
            if (validateForm()) {
                if (isNetworkAvailable() == true) {

                    callForgotPasswordApi();

                } else {
                    Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
                }
            }

        } else if (view == binding.ivBack) {
            finish();
        }

    }

    private void callForgotPasswordApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getForgotPasswordResult(edtEmail);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ForgotPassword.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(ForgotPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        AllResponse allResponse = response.body().getAllResponse();
                        String code = allResponse.getCode();
                        //startActivity(new Intent(ForgotPassword.this, ResetPassword.class));
                        openForgetPasswordPopup(code);

                    } else {
                        Toast.makeText(ForgotPassword.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ForgotPassword.this).hideDialog();
            }
        });

    }

    private void openForgetPasswordPopup(final String code) {

        final OtpdailogueBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.otpdailogue, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                if (!binding.edtCode.equals(code)) {
                    Intent intent = new Intent(ForgotPassword.this, ResetPassword.class);
                    intent.putExtra("edtEmail",edtEmail);
                    startActivity(intent);
                } else {
                    Toast.makeText(ForgotPassword.this, "Please Enter Correct Otp", Toast.LENGTH_LONG).show();
                }
            }
        });

        binding.tvCancel.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
