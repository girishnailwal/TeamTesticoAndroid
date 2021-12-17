package com.teamtasticoapp.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ActivityInviteFriendsBinding;
import com.teamtasticoapp.adapter.InviteFriendAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.FrndJson;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InviteFriends extends BaseActivity implements View.OnClickListener {
    ActivityInviteFriendsBinding binding;
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    ArrayList<FrndJson> arrayList;
    InviteFriendAdapter inviteFriendAdapter;
    String getTeamCode = "";
    String name = "";
    String contactNo = "";
    String getType = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(InviteFriends.this, R.layout.activity_invite_friends);

        getTeamCode = SharedPreferenceWriter.getInstance(InviteFriends.this).getString(SharedPreferenceKey.team_code);
        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        arrayList = new ArrayList<>();

        if (checkPermissionForContacts()) {
            getContactsDetails();
        } else {
            requestPermissionForContacts();
        }

        binding.llAboutUs.setOnClickListener(this);
        binding.llProfile.setOnClickListener(this);
        binding.llAboutUs.setOnClickListener(this);


    }

    private void getContactsDetails() {
        ContentResolver cr = getContentResolver();
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, "upper(" + ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + ") ASC");
//        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
//        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
//                null, null);
        if (phones != null) {
            while (phones.moveToNext()) {
                FrndJson contactsBean = new FrndJson();
                String Name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String Number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String image_uri = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));

                contactsBean.setName(Name);
                contactsBean.setImage(image_uri == null ? "" : image_uri);
                Log.i("Contact", "Number" + Number);
                if (Number.contains("")) {
                    Log.i("Contact", "SelectedNumber" + Number);

                    contactsBean.setNumber(Number.replaceAll("\\s", ""));
                    arrayList.add(contactsBean);
                }
            }

            binding.rvContactlist.setLayoutManager(new LinearLayoutManager(InviteFriends.this));

            inviteFriendAdapter = new InviteFriendAdapter(InviteFriends.this, arrayList);
            binding.rvContactlist.setAdapter(inviteFriendAdapter);

            inviteFriendAdapter.setOnContactItemClickListener(new InviteFriendAdapter.OnContactItemClickListener() {
                @Override
                public void onItemClick(View view, int pos) {

                    /*try {
                        JSONArray jsonArray = new JSONArray();
                        for (FrndJson frndJson : arrayList) {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("number", frndJson.getNumber());
                            jsonArray.put(jsonObject);
                        }
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("token", SharedPreferenceWriter.getInstance(getApplicationContext()).getString(SharedPreferenceKey.token));
                        jsonObject.put("contacts", jsonArray);
                        InviteFriendsService(jsonObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                    FrndJson frndJsonBean = arrayList.get(pos);
                    name = frndJsonBean.getName();
                    contactNo = frndJsonBean.getNumber();

                    // Toast.makeText(InviteFriends.this, "This team code has been sent to" + name, Toast.LENGTH_SHORT).show();
                    InviteFriendsService();
                }
            });


        } else {
            Toast.makeText(this, "No Contacts Found", Toast.LENGTH_SHORT).show();
        }


    }

    private void InviteFriendsService() {

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getSendTeamCodeResult(contactNo, getTeamCode);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(InviteFriends.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {

                        // Toast.makeText(InviteFriends.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        Toast.makeText(InviteFriends.this, "This TeamCode has been sent to " + name, Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(InviteFriends.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // to see server error in logcat
                    Toast.makeText(InviteFriends.this, "server error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(InviteFriends.this).hideDialog();
            }
        });


    }

    private void requestPermissionForContacts() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(InviteFriends.this, Manifest.permission.READ_CONTACTS)) {
            Toast.makeText(this, "Reading Contacts permission needed. Please allow in App Settings for additional functionality.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        } else {
            ActivityCompat.requestPermissions(InviteFriends.this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    }

    private boolean checkPermissionForContacts() {
        if (ContextCompat.checkSelfPermission(InviteFriends.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

   /* private void earnMoneyService(JSONObject jsonObject) {
        try {
            serviceProgressDialog = new ProgressBar(InviteFriends.this);
            serviceProgressDialog.showCustomProgressDialog();

            ApiInterface apiInterface = ApiClientConnection.getInstance().createApiInterface();

            RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), jsonObject.toString());
            Call<PackageDetailResponse> call = apiInterface.invite_friends(requestBody);

            call.enqueue(new retrofit2.Callback<PackageDetailResponse>() {
                @Override
                public void onResponse(Call<PackageDetailResponse> call, Response<PackageDetailResponse> response) {
                    serviceProgressDialog.hideProgressDialog();
                    if (response.isSuccessful()) {
                        PackageDetailResponse offerResponse = response.body();
                        if (offerResponse.getStatus().equalsIgnoreCase("SUCCESS")) {


                            final SweetAlertDialog alert = new SweetAlertDialog(InviteFriends.this);

                            alert.setTitleText("Tappit")
                                    .setContentText("Successfully Invite Friends")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismiss();
                                        }
                                    })
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            alert.show();

                            Toast.makeText(InviteFriends.this, "" + offerResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(InviteFriends.this, "" + offerResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(InviteFriends.this, "Error!", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<PackageDetailResponse> call, Throwable t) {
                    t.printStackTrace();
                    serviceProgressDialog.hideProgressDialog();
                    String s = "";
                }
            });

        } catch (Exception e) {
            e.printStackTrace();


        }


    }*/


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // readContacts();
                    getContactsDetails();
                } else {
                    Toast.makeText(this, "Reading contacts permission is disabled", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }


    @Override
    public void onClick(View view) {

        if (view == binding.llAboutUs) {
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
            } else {
                Toast.makeText(this, "Type Empty", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
