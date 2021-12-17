package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityJoinTeamInfoBinding;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.TakePhoto;
import com.teamtasticoapp.util.Utility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by mobulous55 on 15/2/18.
 */

public class JoinTeamInfo extends BaseActivity implements View.OnClickListener {
    ActivityJoinTeamInfoBinding binding;
    String edtName, edtPosition, edtEmail, edtPassword, getTeamId, getTeamName;

    private final int CAMERA_PIC_REQUEST = 11, REQ_CODE_PICK_IMAGE = 1;
    private File fileFlyer;

    private final int CAMERA_REQ_CODE = 10;
    private final int GALLERY_REQ_CODE = 12;
    private String imageFilePathProfile = null;
    private Uri imageUriProfile = null;

    private String imageFilePath = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join_team_info);

        getTeamId = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_id);
        getTeamName = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.team_name);

        binding.tvTeamName.setText(getTeamName);
        binding.tvJoinTeamInfoTitle.setText(getTeamName);

        binding.joinTeam.setOnClickListener(this);
        binding.ivProfile.setOnClickListener(this);
        binding.ivUploadPhoto.setOnClickListener(this);
        binding.passwordOnOffImg.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);


    }

    private boolean validateForm() {
        boolean validate = true;

        edtName = binding.edtName.getText().toString().trim();
        edtPosition = binding.edtPosition.getText().toString().trim();
        edtEmail = binding.edtEmail.getText().toString().trim();
        edtPassword = binding.passwordEdt.getText().toString().trim();

        if (edtName.length() == 0) {
            Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edtEmail.length() == 0) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Utility.isValidEmail(edtEmail)) {
            Toast.makeText(JoinTeamInfo.this, "Please enter valid email id", Toast.LENGTH_LONG).show();
            return false;
        } else if (edtPassword.length() == 0) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edtPassword.length() >= 20) {
            Toast.makeText(JoinTeamInfo.this, "Password not more than 20 character", Toast.LENGTH_LONG).show();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        if (view == binding.joinTeam) {
            if (validateForm()) {

                if (isNetworkAvailable() == true) {

                    callJoinTeamApi();

                } else {
                    Toast.makeText(this, "Internet Connection Lost!", Toast.LENGTH_LONG).show();
                }

            }

        } else if (view == binding.ivUploadPhoto) {

            selectImage();

        } else if (view == binding.ivProfile) {

            Toast.makeText(this, "Please Complete Profile First", Toast.LENGTH_SHORT).show();

        } else if (view == binding.passwordOnOffImg) {
            if (binding.passwordOnOffImg.getTag().equals("hide")) {
                binding.passwordOnOffImg.setTag("show");
                binding.passwordOnOffImg.setImageDrawable(getDrawable(R.drawable.visible));
                binding.passwordOnOffImg.setSelected(true);
                binding.passwordEdt.setTransformationMethod(null);
                binding.passwordEdt.setSelection(binding.passwordEdt.getText().toString().length());

            } else {
                binding.passwordOnOffImg.setTag("hide");
                binding.passwordOnOffImg.setImageDrawable(getDrawable(R.drawable.hide));
                binding.passwordOnOffImg.setSelected(false);
                binding.passwordEdt.setTransformationMethod(new PasswordTransformationMethod());
                binding.passwordEdt.setSelection(binding.passwordEdt.getText().toString().length());
            }
        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

        }

    }


    private void selectImage() {
        final CharSequence[] items = {"take photo", "take libarary", getResources().getString(R.string.cancel)};

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.info_select_photo_dialog);

        LinearLayout llCamera = (LinearLayout) dialog.findViewById(R.id.llCamera);
        LinearLayout llGallary = (LinearLayout) dialog.findViewById(R.id.llGallary);
        LinearLayout llCancle = (LinearLayout) dialog.findViewById(R.id.llCancle);

        llCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dispatchCameraIntent();
                dialog.dismiss();

            }
        });

        llGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dispatchGalleryIntent();
                dialog.dismiss();

            }
        });

        llCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    private void dispatchGalleryIntent() {
        Intent i = new Intent(this, TakePhoto.class);
        i.putExtra(TakePhoto.FROM, TakePhoto.GALLERY);
        i.putExtra(TakePhoto.SIZE, TakePhoto.WANT_FULL_SIZE);
        startActivityForResult(i, GALLERY_REQ_CODE);

    }

    private void dispatchCameraIntent() {
        Intent i = new Intent(this, TakePhoto.class);
        i.putExtra(TakePhoto.FROM, TakePhoto.CAMERA);
        i.putExtra(TakePhoto.SIZE, TakePhoto.WANT_FULL_SIZE);
        startActivityForResult(i, CAMERA_REQ_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {
            case CAMERA_REQ_CODE: //CAMERA
                if (resultCode == RESULT_OK) {
                    try {

                        imageFilePath = data.getStringExtra("path");
                        final Uri imageUri = data.getParcelableExtra("uri");

                        imageFilePathProfile = imageFilePath;
                        imageUriProfile = imageUri;


                        fileFlyer = new File(imageFilePathProfile);

                       /* if (fileFlyer.exists() && fileFlyer != null) {
                            binding.ivUploadPhoto.setImageURI(Uri.fromFile(fileFlyer));
                        }*/

                        Glide.with(this.getApplicationContext())
                                .load(imageUri)
                                .centerCrop()
                                .into(new SimpleTarget<GlideDrawable>(500, 500) {
                                    @Override
                                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                                        binding.ivUploadPhoto.setVisibility(View.VISIBLE);
                                        binding.ivUploadPhoto.setImageDrawable(resource);

                                    }

                                    @Override
                                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                                        super.onLoadFailed(e, errorDrawable);

                                    }
                                });


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                break;

            case GALLERY_REQ_CODE: //GALLERY
                if (resultCode == RESULT_OK) {
                    try {

                        imageFilePath = data.getStringExtra("path");
                        final Uri imageUri = data.getParcelableExtra("uri");
                        String uriString = imageUri.toString();

                        imageFilePathProfile = imageFilePath;
                        imageUriProfile = imageUri;

                        fileFlyer = new File(imageFilePathProfile);

                        /*if (fileFlyer.exists() && fileFlyer != null) {
                            binding.ivUploadPhoto.setImageURI(Uri.fromFile(fileFlyer));
                        }*/

                        Glide.with(this.getApplicationContext())
                                .load(imageUri)
                                .centerCrop()
                                .into(new SimpleTarget<GlideDrawable>(500, 500) {
                                    @Override
                                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                                        binding.ivUploadPhoto.setVisibility(View.VISIBLE);
                                        binding.ivUploadPhoto.setImageDrawable(resource);

                                    }

                                    @Override
                                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                                        super.onLoadFailed(e, errorDrawable);

                                    }
                                });


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;


            default:
                super.onActivityResult(requestCode, resultCode, data);
        }


    }

    private Map<String, RequestBody> setUpMapData(String the_device_id) {

        Map<String, RequestBody> fields = new HashMap<>();

        RequestBody device_id = RequestBody.create(MediaType.parse("text/plain"), the_device_id);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), edtName);
        RequestBody email_id = RequestBody.create(MediaType.parse("text/plain"), edtEmail);
        RequestBody pwd = RequestBody.create(MediaType.parse("text/plain"), edtPassword);
        RequestBody teamId = RequestBody.create(MediaType.parse("text/plain"), getTeamId);
        RequestBody position = RequestBody.create(MediaType.parse("text/plain"), edtPosition);
        RequestBody device_type = RequestBody.create(MediaType.parse("text/plain"), "android");

        fields.put("name", name);
        fields.put("email", email_id);
        fields.put("password", pwd);
        fields.put("team_id", teamId);
        fields.put("device_id", device_id);
        fields.put("device_type", device_type);
        fields.put("position", position);

        return fields;
    }


    private void callJoinTeamApi() {

        MyDialog.getInstance(this).showDialog();

        String deviceId = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_id);

        if (!deviceId.isEmpty()) {
            RequestBody profile_body;
            MultipartBody.Part profilePart;

            if (fileFlyer != null) {

                //File file = new File(imageFilePath);
                profile_body = RequestBody.create(MediaType.parse("image/*"), fileFlyer);
                profilePart = MultipartBody.Part.createFormData("image", fileFlyer.getName(), profile_body);
            } else {
                profile_body = RequestBody.create(MediaType.parse("image/*"), "");
                profilePart = MultipartBody.Part.createFormData("image", "", profile_body);

            }

            Retrofit retrofit = ApiClient.getClient();
            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            Map<String, RequestBody> map = setUpMapData(deviceId);

            Call<CommonResponse> call = apiInterface.getJoinTeamResult(map, profilePart);
            call.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    MyDialog.getInstance(JoinTeamInfo.this).hideDialog();
                    if (response.isSuccessful()) {
                        if (response.body().getStatus().equals("SUCCESS")) {
                            Toast.makeText(JoinTeamInfo.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                           /* CreateTeamResponse createTeamResponse = response.body().getCreateTeamTResponse();
                            if (!response.body().getCreateTeamTResponse().get().equals("")) {
                                AQuery aQuery = new AQuery(getActivity());
                                aQuery.id(ivUploadPhoto).image(response.body().getCreateTeamTResponse().getImage_url(), false, false, 0, R.drawable.camera);
                            }*/
                            SharedPreferenceWriter.getInstance(JoinTeamInfo.this).writeStringValue(SharedPreferenceKey.token, response.body().getAllResponse().getToken());
                            SharedPreferenceWriter.getInstance(JoinTeamInfo.this).writeStringValue(SharedPreferenceKey.type, response.body().getAllResponse().getType());
                            SharedPreferenceWriter.getInstance(JoinTeamInfo.this).writeStringValue(SharedPreferenceKey.id, response.body().getAllResponse().getId());

                            Intent intent = new Intent(JoinTeamInfo.this, JoinTeamConfirmation.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.putExtra("NAME", edtName);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(JoinTeamInfo.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(JoinTeamInfo.this, "Service Error", Toast.LENGTH_SHORT).show();
                        //and then to see error in logcat

                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    MyDialog.getInstance(JoinTeamInfo.this).hideDialog();
                    t.printStackTrace();
                }
            });

        }

    }
}
