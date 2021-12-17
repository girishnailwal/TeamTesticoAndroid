package com.teamtasticoapp.fragment;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.FragmentGroupChatBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBinding;
import com.teamtasticoapp.adapter.GroupChatAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.GroupChatListModel;
import com.teamtasticoapp.bean.GroupChatListResponse;
import com.teamtasticoapp.bean.SendGroupChatModel;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.HelperClass;
import com.teamtasticoapp.util.TakePhoto;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mobulous55 on 14/2/18.
 */
//ReceiverActivity
//An activity that watches for notifications for the event named "PUSH_CHAT".
public class GroupChatFragment extends Fragment implements View.OnClickListener {
    FragmentGroupChatBinding binding;
    View rootView;
    String Authorization;
    public static boolean isGroupChatFragmentOnForeground = false;

    private File fileFlyer;
    private final int CAMERA_REQ_CODE = 10;
    private final int GALLERY_REQ_CODE = 12;
    private String imageFilePathProfile = null;
    private Uri imageUriProfile = null;
    private String imageFilePath = null;

    List<GroupChatListResponse> groupChatListResponseList = new ArrayList<>();
    GroupChatAdapter groupChatAdapter;

    String messageId = "";

    public GroupChatFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_group_chat, container, false);
        rootView = binding.getRoot();

        isGroupChatFragmentOnForeground = true;

        binding.ivSend.setOnClickListener(this);
        binding.ivAttach.setOnClickListener(this);

        return rootView;
    }



    //1.Create a broadcast receiver:
    // Now whenever a localbroadcast is sent from applications' activity or service,
    // onReceive of pushChatBReceiver,new IntentFilter("PUSH_CHAT") will be called :).

    //Unlike Activities broadcast receivers do not have any user interface
    //but may create a status bar notification
    //This method is called when this BroadcastReceiver receives an Intent broadcast/Intent object.

    BroadcastReceiver pushChatBReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // intent can contain any data
            // Log.d("dev","onReceive called");
            Bundle bundle = intent.getExtras();

           // callGroupMessageListApi();
        }
    };

    //2.Register your receiver in onResume of activity like:
    @Override
    public void onResume() {
        super.onResume();

        isGroupChatFragmentOnForeground = true;

        callGroupMessageListApi();

        // REGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(pushChatBReceiver,
                new IntentFilter("PUSH_CHAT"));
    }

    //3.unRegister receiver in onPause/onStop:
    //please note that onDestroy() is not guaranteed to be called!!!
    @Override
    public void onStop() {
        super.onStop();

        isGroupChatFragmentOnForeground = false;

        //UNREGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(pushChatBReceiver);
    }

    private void callGroupMessageListApi() {

        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).hideDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<GroupChatListModel> call = apiInterface.getGroupMessageTeamListResult(map);

        call.enqueue(new Callback<GroupChatListModel>() {
            @Override
            public void onResponse(Call<GroupChatListModel> call, Response<GroupChatListModel> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        //to get all response here,

                        groupChatListResponseList.clear();

                        if (response.body().getGroupChatListResponses() != null &&
                                response.body().getGroupChatListResponses().size() > 0) {

                            groupChatListResponseList.addAll(response.body().getGroupChatListResponses());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerView.setLayoutManager(linearLayoutManager);

                            groupChatAdapter = new GroupChatAdapter(getActivity(), groupChatListResponseList);
                            binding.recyclerView.setAdapter(groupChatAdapter);

                            groupChatAdapter.setOnImageItemClickListener(new GroupChatAdapter.OnImageItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    String ivUrl = groupChatListResponseList.get(pos).getAttachment();

                                    showDialog1(ivUrl);
                                }
                            });

                            groupChatAdapter.setOnGroupChatItemDeleteListener(new GroupChatAdapter.OnGroupChatItemDeleteListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    messageId = groupChatListResponseList.get(pos).getMessage_id();
                                    openWantToDeletePopup(pos);
                                }
                            });

                            binding.recyclerView.scrollToPosition(groupChatListResponseList.size() - 1);


                        } else {
                            // Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<GroupChatListModel> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

    private void openWantToDeletePopup(final int pos) {

        PopupWantToDeleteChatBinding binding;

        final Dialog dialog = new Dialog(getActivity(), R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.popup_want_to_delete_chat, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                callDeleteChatItemApi(pos);

            }
        });

        binding.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void callDeleteChatItemApi(final int pos) {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getDeleteGroupChatItemResult(map, messageId);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        groupChatAdapter.deleteItem(pos);

                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }


    private void showDialog1(String ivUrlSender) {
        final Dialog dialog1 = new Dialog(getActivity(), R.style.ThemeDialogCustom);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.dialog_zoom);

        ImageView yes_btn = (ImageView) dialog1.findViewById(R.id.img_main_iv);
        ImageView no_btn = (ImageView) dialog1.findViewById(R.id.img_close_iv);


        Glide.with(this)
                .load(ivUrlSender)
                .into(yes_btn);

        dialog1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable());

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        dialog1.show();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivSend:
                if (binding.edtMessage.getText().toString().trim().length() > 0) {
                    callSendGroupChatApi();
                }
                break;

            case R.id.ivAttach:
                dispatchGalleryIntent();
                break;

            default:
                break;
        }
    }

    private void dispatchGalleryIntent() {
        Intent i = new Intent(getActivity(), TakePhoto.class);
        i.putExtra(TakePhoto.FROM, TakePhoto.GALLERY);
        i.putExtra(TakePhoto.SIZE, TakePhoto.WANT_FULL_SIZE);
        startActivityForResult(i, GALLERY_REQ_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {

            case GALLERY_REQ_CODE: //GALLERY
                if (resultCode == RESULT_OK) {
                    try {

                        imageFilePath = data.getStringExtra("path");
                        final Uri imageUri = data.getParcelableExtra("uri");

                        imageFilePathProfile = imageFilePath;
                        imageUriProfile = imageUri;

                        fileFlyer = new File(imageFilePathProfile);

                        imageSendDialog(imageFilePath);

//                        Intent intent=new Intent(this,GallaryImagePlace.class);
//                        intent.putExtra("path",imageFilePath);
//                        intent.putExtra("uri",imageUri);
//                        startActivity(intent);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                break;


            default:
                super.onActivityResult(requestCode, resultCode, data);
        }


    }

    private void imageSendDialog(String imgPath) {

        final Dialog dialog1 = new Dialog(getActivity(), R.style.ThemeDialogCustom);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.dialog_image_select);

        Window window = getActivity().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setDimAmount(4f);
        }


        ImageView img_v = (ImageView) dialog1.findViewById(R.id.iv);
        Button btnCancel = (Button) dialog1.findViewById(R.id.btnCancel);
        Button btnSend = (Button) dialog1.findViewById(R.id.btnSend);


        Glide.with(getActivity().getApplicationContext())
                .load(imgPath)
                .fitCenter()
                .into(img_v);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSendGroupChatApi();
                dialog1.dismiss();

            }
        });

        dialog1.show();


    }

    private Map<String, RequestBody> setUpMapData() {

        Map<String, RequestBody> fields = new HashMap<>();

        RequestBody message = RequestBody.create(MediaType.parse("text/plain"), binding.edtMessage.getText().toString());
        fields.put("message", message);

        return fields;
    }

    private void callSendGroupChatApi() {

        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        //start multipart for image
        RequestBody profile_body;
        MultipartBody.Part profilePart;

        if (fileFlyer != null) {
            profile_body = RequestBody.create(MediaType.parse("image"), fileFlyer);
            profilePart = MultipartBody.Part.createFormData("image", fileFlyer.getName(), profile_body);
        } else {
            profile_body = RequestBody.create(MediaType.parse("image"), "");
            profilePart = MultipartBody.Part.createFormData("image", "", profile_body);
        }
        //end multipart image


        //Call<SendGroupChatModel> call = apiInterface.getSendGroupMessageResult(map, binding.edtMessage.getText().toString());

        //calling header token,multipart data,multipart image
        Call<SendGroupChatModel> call = apiInterface.getSendGroupMessageResult(map, setUpMapData(), profilePart);
        call.enqueue(new Callback<SendGroupChatModel>() {
            @Override
            public void onResponse(Call<SendGroupChatModel> call, Response<SendGroupChatModel> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //to get all response here,

                        binding.edtMessage.setText("");
                        callGroupMessageListApi();
                        HelperClass.hideSoftKeyBoard(getActivity());
                    }
                }
            }

            @Override
            public void onFailure(Call<SendGroupChatModel> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();

            }
        });


    }
}
