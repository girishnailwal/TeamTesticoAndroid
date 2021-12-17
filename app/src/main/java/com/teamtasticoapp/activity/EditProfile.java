package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityEditProfileBinding;
import com.teamtasticoapp.bean.AllResponse;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.HelperClass;
import com.teamtasticoapp.util.TakePhoto;

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
 * Created by mobulous55 on 24/2/18.
 */

public class EditProfile extends BaseActivity implements View.OnClickListener {
    ActivityEditProfileBinding binding;
    String edtNameProfile, edtPositionProfile, edtEmailProfile;
    String edtImageProfile = "";

    String Authorization = "";
    private String email = "";
    private String name = "";
    private String position = "";
    private String image = "";
    private int mType;

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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);

        Bundle bundle = getIntent().getExtras();

        email = bundle.getString("getGmail");
        name = bundle.getString("getUserName");
        position = bundle.getString("getForward");
        image = bundle.getString("getImage");
        mType = bundle.getInt("type", 0);


        binding.edtName.setText(name);
        binding.edtPosition.setText(position);
        binding.edtEmail.setText(email);

        if (!image.equals("")) {
          /*  AQuery aQuery = new AQuery(EditProfile.this);
            aQuery.id(binding.ivEditCoach).image(image, false, false, 0, R.drawable.profile_pic);*/

            Picasso.with(EditProfile.this).load(image).into(binding.ivEditCoach);
        }

        binding.ivEditCoach.setOnClickListener(this);
        binding.ivCamera.setOnClickListener(this);
        binding.btnUpdateProfile.setOnClickListener(this);
        binding.tvChangePwd.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llTeam.setOnClickListener(this);
        binding.llChat.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view == binding.ivEditCoach || view == binding.ivCamera) {
            selectImage();

        } else if (view == binding.btnUpdateProfile) {
            callEditProfileApi();

        } else if (view == binding.tvChangePwd) {
            Intent intent = new Intent(this, ChangePassword.class);
            startActivity(intent);

        } else if (view == binding.llAboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);

            HelperClass.hideSoftKeyBoard(EditProfile.this);

        } else if (view == binding.llProfile) {
            if (mType == 1) {
                // coach screen
                startActivity(new Intent(EditProfile.this, ProfileCoach.class));
                finish();
            } else if (mType == 2) {
                //player screen
                startActivity(new Intent(EditProfile.this, ProfileTeamPlayer.class));
                finish();
            }

        } else if (view == binding.llTeam) {
            Intent intent = new Intent(EditProfile.this, TeamPageHome.class);
            startActivity(intent);

        } else if (view == binding.llChat) {
            Intent intent = new Intent(EditProfile.this, TeamPageHome.class);
            Bundle bundle = new Bundle();
            bundle.putString("from", "profile");
            intent.putExtras(bundle);
            startActivity(intent);
        }


    }

    //start for multipart data
    private Map<String, RequestBody> setUpMapData() {

        Map<String, RequestBody> fields = new HashMap<>();

        String email = "";
        String name = "";
        String position = "";

        RequestBody email_idbody = null;
        //if email of before is equals to editing email,then not to send/put to server
        if (this.email.equals(binding.edtEmail.getText().toString())) {
            email = "";
        } else {
            email = binding.edtEmail.getText().toString();
            email_idbody = RequestBody.create(MediaType.parse("text/plain"), email);
            fields.put("email", email_idbody);
        }

        if (this.name.equals(binding.edtName.getText().toString())) {
            //name="";
            name = binding.edtName.getText().toString();
        } else {
            name = binding.edtName.getText().toString();
        }


        if (this.position.equals(binding.edtPosition.getText().toString())) {
            //position="";
            position = binding.edtPosition.getText().toString();
        } else {
            position = binding.edtPosition.getText().toString();
        }

        RequestBody namebody = RequestBody.create(MediaType.parse("text/plain"), name);
        RequestBody positionbody = RequestBody.create(MediaType.parse("text/plain"), position);

        fields.put("name", namebody);
        fields.put("position", positionbody);

        return fields;
    }
    //end multipart data


    private void callEditProfileApi() {
        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header


        //start multipart for image
        RequestBody profile_body;
        MultipartBody.Part profilePart;

        if (fileFlyer != null) {

            profile_body = RequestBody.create(MediaType.parse("image/*"), fileFlyer);
            profilePart = MultipartBody.Part.createFormData("image", fileFlyer.getName(), profile_body);
        } else {
            profile_body = RequestBody.create(MediaType.parse("image/*"), "");
            profilePart = MultipartBody.Part.createFormData("image", "", profile_body);
        }
        //end multipart image


        //calling header token,multipart data,multipart image
        Call<CommonResponse> call = apiInterface.getEditProfileResult(map, setUpMapData(),
                profilePart);
        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(EditProfile.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,
                        AllResponse allResponse = response.body().getAllResponse();

                        edtNameProfile = allResponse.getName();
                        edtPositionProfile = allResponse.getPosition();
                        edtEmailProfile = allResponse.getEmail();
                        edtImageProfile = allResponse.getImage();


                        binding.edtName.setText(edtNameProfile);
                        binding.edtPosition.setText(edtPositionProfile);
                        binding.edtEmail.setText(edtEmailProfile);

                        if (!edtImageProfile.isEmpty()) {
                            String url = edtImageProfile;
                            Picasso.with(EditProfile.this)
                                    .load(url)
                                    .into(binding.ivEditCoach);
                        }

                        if (mType == 1) {
                            //coach screen
                            startActivity(new Intent(EditProfile.this, ProfileCoach.class));
                            finish();

                        } else if (mType == 2) {
                            //player screen
                            startActivity(new Intent(EditProfile.this, ProfileTeamPlayer.class));
                            finish();
                        }

                    } else {
                        Toast.makeText(EditProfile.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(EditProfile.this).hideDialog();
            }
        });


    }

    private void selectImage() {

        final CharSequence[] items = {"take photo", "take library", getResources().getString(R.string.cancel)};

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
                            binding.ivEditCoach.setImageURI(Uri.fromFile(fileFlyer));
                        }*/

                        Glide.with(this.getApplicationContext())
                                .load(imageUri)
                                .centerCrop()
                                .into(new SimpleTarget<GlideDrawable>(500, 500) {
                                    @Override
                                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                                        binding.ivEditCoach.setVisibility(View.VISIBLE);
                                        binding.ivEditCoach.setImageDrawable(resource);

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

                       /* if (fileFlyer.exists() && fileFlyer != null) {
                            binding.ivEditCoach.setImageURI(Uri.fromFile(fileFlyer));
                        }*/

                        Glide.with(this.getApplicationContext())
                                .load(imageUri)
                                .centerCrop()
                                .into(new SimpleTarget<GlideDrawable>(500, 500) {
                                    @Override
                                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                                        binding.ivEditCoach.setVisibility(View.VISIBLE);
                                        binding.ivEditCoach.setImageDrawable(resource);

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


}
