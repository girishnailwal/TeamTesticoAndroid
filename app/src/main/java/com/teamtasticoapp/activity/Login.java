package com.teamtasticoapp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityLoginBinding;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.MyApplication;
import com.teamtasticoapp.util.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by mobulous55 on 12/2/18.
 */

public class Login extends BaseActivity implements View.OnClickListener {
    ActivityLoginBinding binding;
    private String getDeviceId = "";
    boolean isRememberChecked = false;//by default boolean false
    String email = "";
    String password = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.loginButton.setOnClickListener(this);
        binding.tvForgotPass.setOnClickListener(this);
        binding.llRemember.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        setRememberMe();
    }

    // METHOD: TO SET UP FIELDS ACCORDING TO REMEMBER ME
    private void setRememberMe() {
        isRememberChecked = SharedPreferenceWriter.getInstance(Login.this).
                getBoolean(SharedPreferenceKey.rememberme, false);

        String email = SharedPreferenceWriter.getInstance(Login.this).getString(SharedPreferenceKey.email);
        //binding.edtEmail.setText(email); if we want to gmail always see
        String pass = SharedPreferenceWriter.getInstance(Login.this).getString(SharedPreferenceKey.edtpassword);

        if (isRememberChecked) {

            binding.edtEmail.setText(email);
            binding.edtPass.setText(pass);

            Log.d("Login", "Email: " + email);
            Log.d("Login", "Password: " + pass);

            binding.ivRemember.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.checked));
        } else {
            binding.ivRemember.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.uncheck));
        }

    }


    private boolean validateForm() {
        boolean flag = true;

        email = binding.edtEmail.getText().toString().trim();
        password = binding.edtPass.getText().toString().trim();

        if (email.length() == 0) {
            Toast.makeText(Login.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Utility.isValidEmail(email)) {
            Toast.makeText(Login.this, "Please Enter Valid Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() == 0) {
            Toast.makeText(Login.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() >= 20) {
            Toast.makeText(Login.this, "Password Should Not More Than 20 Character", Toast.LENGTH_LONG).show();
            return false;
        }

        return flag;
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

        if (view == binding.loginButton) {

            if (validateForm()) {

                if (isNetworkAvailable() == true) {

                    callLoginApi();

                } else {
                    Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
                }

            }

        } else if (view == binding.tvForgotPass) {
            Intent intent = new Intent(this, ForgotPassword.class);
            startActivity(intent);

        } else if (view == binding.llRemember) {

            email = binding.edtEmail.getText().toString();
            password = binding.edtPass.getText().toString();

            if (!isRememberChecked) {

                isRememberChecked = true;
                binding.ivRemember.setImageResource(R.drawable.checked);

                binding.edtEmail.setText(email);
                binding.edtPass.setText(password);

                SharedPreferenceWriter.getInstance(this).writeStringValue(SharedPreferenceKey.email, email);
                SharedPreferenceWriter.getInstance(this).writeStringValue(SharedPreferenceKey.edtpassword, password);

            } else {
                isRememberChecked = false;
                binding.ivRemember.setImageResource(R.drawable.uncheck);

                SharedPreferenceWriter.getInstance(this).writeStringValue(SharedPreferenceKey.email, "");
                SharedPreferenceWriter.getInstance(this).writeStringValue(SharedPreferenceKey.edtpassword, "");

            }

            SharedPreferenceWriter.getInstance(this).writeBooleanValue(SharedPreferenceKey.rememberme, isRememberChecked);


        } else if (view == binding.ivBack) {
            finish();
        }
    }

    private void callLoginApi() {
        getDeviceId = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_id);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getLoginResult(email, password, getDeviceId, "android");

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Login.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.id, response.body().getAllResponse().getId());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.name, response.body().getAllResponse().getName());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.email, response.body().getAllResponse().getEmail());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.image, response.body().getAllResponse().getImage());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.is_admin, response.body().getAllResponse().getIs_admin());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.position, response.body().getAllResponse().getPosition());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.token, response.body().getAllResponse().getToken());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.device_id, response.body().getAllResponse().getDevice_id());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.created_at, response.body().getAllResponse().getCreated_at());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.updated_at, response.body().getAllResponse().getUpdated_at());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.type, response.body().getAllResponse().getType());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.team_name, response.body().getAllResponse().getTeam_name());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.team_code, response.body().getAllResponse().getTeam_code());

                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.currentLogin, "true");
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.edtpassword, password);

                        Intent intent = new Intent(Login.this, TeamPageHome.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Login.this.finishAffinity();

                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // to see server error in logcat
                    Toast.makeText(Login.this, "server error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Login.this).hideDialog();
            }
        });

    }


    //    METHOD: TO GET DEVICE_TOKEN FROM FCM
    private void getDeviceToken() {

        final Thread thread = new Thread() {
            @Override
            public void run() {
                Log.e(">>>>>>>>>>>>>>", "thread IS  running");
                SharedPreferenceWriter mPreference = SharedPreferenceWriter.getInstance(getApplicationContext());

                Log.w("getDeviceToken", "Previous Device Token : " + mPreference.getString(SharedPreferenceKey.device_id));

                mPreference.writeStringValue(SharedPreferenceKey.device_id, "");

                try {
                    if (mPreference.getString(SharedPreferenceKey.device_id).isEmpty()) {
                        String token = FirebaseInstanceId.getInstance().getToken();
//                        String token = android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(),
//                                android.provider.Settings.Secure.ANDROID_ID);
                        Log.e("Generated Device Token", "-->" + token);
                        if (token == null) {
                            getDeviceToken();
                        } else {
                            mPreference.writeStringValue(SharedPreferenceKey.device_id, token);
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }


}
