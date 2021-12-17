package com.teamtasticoapp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityJoinTeamBinding;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 12/2/18.
 */

public class JoinTeam extends BaseActivity implements View.OnClickListener {
    ActivityJoinTeamBinding binding;
    String edtTeamCode;
    boolean isTermsChecked = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_join_team);

        binding.next.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTermAndCondition.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
    }

    private boolean validateForm() {
        boolean validate = true;
        edtTeamCode = binding.edtTeamCode.getText().toString().trim();

        if (edtTeamCode.isEmpty() && edtTeamCode.equals("")) {
            Toast.makeText(this, "Please Enter Team Code", Toast.LENGTH_SHORT).show();
            return false;
        }
        return validate;
    }

    @Override
    public void onClick(View view) {

        if (view == binding.next) {
            if (validateForm()) {
                if (!isTermsChecked) {
                    callCheckTeamCodeApi();
                } else
                    Toast.makeText(this, "Please Accept Terms & Conditions And Privacy Policies", Toast.LENGTH_LONG).show();
            }

        } else if (view == binding.llProfile) {

            if (!isTermsChecked) {
                Toast.makeText(this, "Please Complete Profile First", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Please Complete Profile First", Toast.LENGTH_SHORT).show();

        } else if (view == binding.llTermAndCondition) {

            if (validateForm()) {
                if (isTermsChecked) {
                    isTermsChecked = false;
                    binding.imgChecked.setImageResource(R.drawable.checked);

                    binding.tvTerms.setClickable(true);
                    binding.tvTerms.setMovementMethod(LinkMovementMethod.getInstance());
                    binding.tvTerms.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                            browserIntent.setData(Uri.parse("https://teamtastico.com/community/terms/"));
                            startActivity(browserIntent);
                        }
                    });
                } else {
                    isTermsChecked = true;
                    binding.imgChecked.setImageResource(R.drawable.uncheck);
                }

            }

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
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
                MyDialog.getInstance(JoinTeam.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(JoinTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        SharedPreferenceWriter.getInstance(JoinTeam.this).writeStringValue(SharedPreferenceKey.coach_id, response.body().getAllResponse().getCoach_id());
                        SharedPreferenceWriter.getInstance(JoinTeam.this).writeStringValue(SharedPreferenceKey.team_code, response.body().getAllResponse().getTeam_code());
                        SharedPreferenceWriter.getInstance(JoinTeam.this).writeStringValue(SharedPreferenceKey.team_name, response.body().getAllResponse().getTeam_name());
                        SharedPreferenceWriter.getInstance(JoinTeam.this).writeStringValue(SharedPreferenceKey.team_id, response.body().getAllResponse().getTeam_id());

                        Intent intent = new Intent(JoinTeam.this, JoinTeamInfo.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(JoinTeam.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(JoinTeam.this).hideDialog();
            }
        });
    }

}
