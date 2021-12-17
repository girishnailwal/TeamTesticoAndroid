package com.teamtasticoapp.activity;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
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
import com.teamtasticoapp.databinding.ActivityIndividualChatDetailBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBinding;
import com.teamtasticoapp.adapter.IndividualChatDetailAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.IndividualMessageDetailsModel;
import com.teamtasticoapp.bean.IndividualMessageDetailsResponse;
import com.teamtasticoapp.bean.SendIndividualChatModel;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.fcm.MyFirebaseMessagingService;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.HelperClass;
import com.teamtasticoapp.util.TakePhoto;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

//ReceiverActivity
//An activity that watches for notifications for the event named "PUSH_CHAT".
public class IndividualChatDetail extends BaseActivity implements View.OnClickListener {
    ActivityIndividualChatDetailBinding binding;
    String Authorization = "";
    String receiverId = "";
    private String chatId = "";
    private String now_chatId = "";
    String mName = "";
    String getType = "";
    boolean isMessageSent = false;//by default
    String messageId = "";

    private File fileFlyer;

    private final int CAMERA_REQ_CODE = 10;
    private final int GALLERY_REQ_CODE = 12;
    private String imageFilePathProfile = null;
    private Uri imageUriProfile = null;
    private String imageFilePath = null;

    IndividualChatDetailAdapter individualChatDetailAdapter;
    List<IndividualMessageDetailsResponse> senderReceiverList = new ArrayList<>();
    public static boolean isIndividualChatOnForeground = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_individual_chat_detail);

        getType = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.type);

        isIndividualChatOnForeground = true;

        //to get required data which are coming from activities
        if (getIntent() != null) {
            if (getIntent().hasExtra("name")) {
                mName = getIntent().getStringExtra("name");
            }
            if (getIntent().hasExtra("chatId")) {
                chatId = getIntent().getStringExtra("chatId");
            }
            if (getIntent().hasExtra("receiverId")) {
                receiverId = getIntent().getStringExtra("receiverId");
            }

            //to get required data in onCreate() which are coming from push notification
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String from = bundle.getString("from");
                if ("fcm".equalsIgnoreCase(from)) {
                    if (getIntent().hasExtra("sender_name")) {
                        mName = getIntent().getStringExtra("sender_name");
                    }
                    if (getIntent().hasExtra("chat_id")) {
                        chatId = getIntent().getStringExtra("chat_id");
                    }
                    if (getIntent().hasExtra("receiver_id")) {
                        receiverId = getIntent().getStringExtra("receiver_id");
                    }
                }
            }
        }
// first time we hit history/detail api,because when we click on + button,it means we open history of user
// then after come at the detail screen we call send api but before this we hit detail api.

        //in onCreate() we make breakpoint and after that where chatting happen means in parameter what we send
        //and after getting response from api on chatId.

        //to come from anywhere either from activity or push notification,chatId must be now_chatId
        now_chatId = chatId;

        callIndividualChatDetailApi();

        binding.tvToWhomChatUserName.setText(mName);

        binding.ivBackButton.setOnClickListener(this);
        binding.ivProfile.setOnClickListener(this);
        binding.ivSend.setOnClickListener(this);
        binding.ivAttach.setOnClickListener(this);
    }

    // 1.Create a broadcast receiver:
    // Now whenever a localbroadcast is sent from applications' activity or service,
    // onReceive of pushChatBReceiver,new IntentFilter("PUSH_CHAT") will be called :).

    // Unlike Activities broadcast receivers do not have any user interface
    // but may create a status bar notification
    // This method is called when this BroadcastReceiver receives an Intent broadcast/Intent object.

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "PUSH_CHAT" is broadcasted.

    //to receive all data which is broadcasted from an Intent Object with an action named "PUSH_CHAT" from SenderActivity
    //called from onResume() bcz. onCreate() calls only one time
    BroadcastReceiver pushChatBReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Toast.makeText(context, "push came", Toast.LENGTH_SHORT).show();

            // Get the bundle
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                // Extract the data…
                String from = bundle.getString("from");
                // Log.d("receiver", "Got message: " + from);

                if ("fcm".equalsIgnoreCase(from)) {

                    String chatId = "";

                    String sender_id = "";
                    String sender_image = "";
                    String sender_name = "";

                    String receiverId = "";
                    String receiver_name = "";
                    String receiver_image = "";

                    String message_time = "";
                    String message = "";
                    String attachmentImg = "";


                    if (intent.hasExtra("chat_id")) {
                        chatId = intent.getStringExtra("chat_id");
                    }

                    if (intent.hasExtra("sender_id")) {
                        sender_id = intent.getStringExtra("sender_id");
                    }

                    if (intent.hasExtra("sender_name")) {
                        sender_name = intent.getStringExtra("sender_name");
                    }

                    if (intent.hasExtra("sender_image")) {
                        sender_image = intent.getStringExtra("sender_image");
                    }

                    if (intent.hasExtra("receiver_id")) {
                        receiverId = intent.getStringExtra("receiver_id");
                    }

                    if (intent.hasExtra("receiver_name")) {
                        receiver_name = intent.getStringExtra("receiver_name");
                    }

                    if (intent.hasExtra("receiver_image")) {
                        receiver_image = intent.getStringExtra("receiver_image");
                    }

                    if (intent.hasExtra("message")) {
                        message = intent.getStringExtra("message");
                    }

                    if (intent.hasExtra("message_time")) {
                        message_time = intent.getStringExtra("message_time");
                    }

                    if (intent.hasExtra("attachment")) {
                        attachmentImg = intent.getStringExtra("attachment");
                    }

                    //when third person send messages to either sender or receiver while sender and receiver are chatting i.e both are on screen,
                    //messages shouldn't be come at anyone foreground screen.
                    //push must be come in background
                    if (now_chatId != null && !now_chatId.isEmpty()) {
                        if (now_chatId.equalsIgnoreCase(chatId)) {
                            IndividualMessageDetailsResponse bean = new IndividualMessageDetailsResponse();

                            bean.setChat_id(chatId);

                            bean.setSender_id(sender_id);
                            bean.setSender_name(sender_name);
                            bean.setSender_image(sender_image);

                            bean.setReceiver_id(receiverId);
                            bean.setReceiver_name(receiver_name);
                            bean.setReceiver_image(receiver_image);

                            bean.setMessage(message);
                            bean.setMessage_time(message_time);

                            bean.setAttachment(attachmentImg);

                            //when push come then add(append) item at adapter when response is get from fcm
                            if (individualChatDetailAdapter != null) {

                                individualChatDetailAdapter.addItem(bean);
                                senderReceiverList = individualChatDetailAdapter.getArrayList();

                                binding.recyclerViewSenderReceiver.scrollToPosition(senderReceiverList.size() - 1);

                                binding.edtMessage.setText("");

                                HelperClass.hideSoftKeyBoard(IndividualChatDetail.this);
                            } else {
                                //do nothing
                            }
                        } else {
                            //for push came in background when third person sent message to anyone
                            sendNotification(bundle);

                        }
                    }
                }
            }
        }
    };


    private void sendNotification(Bundle bundle) {
        Intent intent = new Intent(this, IndividualChatDetail.class);
        intent.putExtras(bundle);

        String message = bundle.getString("message");

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)

                .setSmallIcon(R.drawable.app_logo)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(message)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setColor(ContextCompat.getColor(IndividualChatDetail.this, R.color.colorPrimary))
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(((int) System.currentTimeMillis()) /* ID of notification */, notificationBuilder.build());
        }
    }


    //2.Register your receiver in onResume of activity like:
    @Override
    protected void onResume() {
        super.onResume();
        isIndividualChatOnForeground = true;

        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "PUSH_CHAT".
        // REGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(IndividualChatDetail.this).registerReceiver(pushChatBReceiver,
                new IntentFilter("PUSH_CHAT"));

    }

    //3.unRegister receiver in onPause/onStop:
    @Override
    protected void onStop() {
        super.onStop();
        isIndividualChatOnForeground = false;
        // Unregister since the activity is about to be closed.
        //UNREGISTER LocalBroadcastManager TO HANDLE PUSH
        LocalBroadcastManager.getInstance(IndividualChatDetail.this).unregisterReceiver(pushChatBReceiver);
    }

    //please note that onDestroy() is not guaranteed to be called unregisterReceiver()!!!
    @Override
    protected void onDestroy() {
        super.onDestroy();

        isIndividualChatOnForeground = false;
    }


    private void callIndividualChatDetailApi() {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<IndividualMessageDetailsModel> call = apiInterface.
                getIndividualMessageDetailsResult(map, chatId);

        call.enqueue(new Callback<IndividualMessageDetailsModel>() {
            @Override
            public void onResponse(Call<IndividualMessageDetailsModel> call, Response<IndividualMessageDetailsModel> response) {
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(IndividualChatDetail.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
// at the time of only send api,we do isMessageSent = true.here we don't send message,only have to show chat details.
// to see chat details between sender and receiver,we need chatId which is unique(same) for that particular sender and receiver.

                        Log.w("send", "5");
                        isMessageSent = false;

                        if (response.body().getIndividualMessageDetailsResponses() != null && response.body().getIndividualMessageDetailsResponses().size() > 0) {
                            senderReceiverList.clear();
                            senderReceiverList.addAll(response.body().getIndividualMessageDetailsResponses());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(IndividualChatDetail.this);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerViewSenderReceiver.setLayoutManager(linearLayoutManager);

                            individualChatDetailAdapter = new IndividualChatDetailAdapter(IndividualChatDetail.this, senderReceiverList);
                            binding.recyclerViewSenderReceiver.setAdapter(individualChatDetailAdapter);

                            individualChatDetailAdapter.setOnImageItemClickListener(new IndividualChatDetailAdapter.OnImageItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    String ivUrl = senderReceiverList.get(pos).getAttachment();
                                    showDialog1(ivUrl);
                                }
                            });

                            individualChatDetailAdapter.setOnChatItemDeleteListener(new IndividualChatDetailAdapter.OnChatItemDeleteListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    messageId = senderReceiverList.get(pos).getMessage_id();
                                    openWantToDeletePopup(pos);
                                }
                            });
                            //to scroll up automatically
                            binding.recyclerViewSenderReceiver.scrollToPosition(senderReceiverList.size() - 1);
                        }

                    } else {
                        isMessageSent = false;
                    }

                } else {
                    // to see server error in logcat
                    Toast.makeText(IndividualChatDetail.this, "server error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IndividualMessageDetailsModel> call, Throwable t) {
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
                isMessageSent = false;
            }
        });
    }

    private void callDeleteChatItemApi(final int pos) {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getDeleteChatItemResult(map, messageId);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(IndividualChatDetail.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        individualChatDetailAdapter.deleteItem(pos);

                    } else {
                        Toast.makeText(IndividualChatDetail.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
            }
        });
    }

    private void showDialog1(String ivUrlSender) {
        final Dialog dialog1 = new Dialog(this, R.style.ThemeDialogCustom);
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

    private void openWantToDeletePopup(final int pos) {
        PopupWantToDeleteChatBinding binding;

        final Dialog dialog = new Dialog(this, R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.popup_want_to_delete_chat, null, false);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBackButton:
                finish();
                break;

            case R.id.ivSend:
                //isMessageSent is false and here meet !isMessageSent(not false) means true i.e run if statement
                //because if(condition) always returns true if it happens true.
                //isMessageSent is false means it execute else part but !isMessageSent is written,so it execute if part

                if (!isMessageSent) {
                    Log.w("send", "isMessageSent: " + false);
                    if (binding.edtMessage.getText().toString().trim().length() > 0) {
                        Log.w("send", "0");
                        callSendIndividualChatApi();
                    }
                } else {
                    Log.w("send", "isMessageSent: " + true);
                }
                break;

            case R.id.ivAttach:

                dispatchGalleryIntent();
                break;

            case R.id.ivProfile:
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
                break;

            default:
                break;

        }
    }


    private void dispatchGalleryIntent() {
        Intent i = new Intent(this, TakePhoto.class);
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

        final Dialog dialog1 = new Dialog(this, R.style.ThemeDialogCustom);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.dialog_image_select);

        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setDimAmount(4f);
        }

        ImageView img_v = (ImageView) dialog1.findViewById(R.id.iv);
        Button btnCancel = (Button) dialog1.findViewById(R.id.btnCancel);
        Button btnSend = (Button) dialog1.findViewById(R.id.btnSend);


        Glide.with(IndividualChatDetail.this.getApplicationContext())
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
                isMessageSent = false;
                callSendIndividualChatApi();
                dialog1.dismiss();

            }
        });

        dialog1.show();


    }

    //setup map data for send messages
    private Map<String, RequestBody> setUpMapData() {

        Map<String, RequestBody> fields = new HashMap<>();

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();

            if (bundle != null) {
                String from = bundle.getString("from");
                if (from != null) {
                    if ("fcm".equalsIgnoreCase(from)) {
                        if (getIntent().hasExtra("name")) {
                            mName = getIntent().getStringExtra("name");
                        }
                        if (getIntent().hasExtra("chat_id")) {
                            chatId = getIntent().getStringExtra("chat_id");
                        }
                        //when push came the sender of msg is receiver for you (who is logged in)
                        if (getIntent().hasExtra("sender_id")) {
                            receiverId = getIntent().getStringExtra("sender_id");
                        }
                    }
                } else {
                    if (getIntent().hasExtra("name")) {
                        mName = getIntent().getStringExtra("name");
                    }
                    if (getIntent().hasExtra("chatId")) {
                        chatId = getIntent().getStringExtra("chatId");
                    }
                    if (getIntent().hasExtra("receiverId")) {
                        receiverId = getIntent().getStringExtra("receiverId");
                    }
                }

            }
        }

        //we get chatId from intent so, in intent, chatId will always meet empty.
        //first time chatId will meet blank so it will go empty in sendApi.
        //but after sending message 1st time,we get response from Api and in this response we get chatId and then sent this now_chatId in sendApi always again.

        String the_chatId = "";
        if (now_chatId != null && !now_chatId.isEmpty()) {
            the_chatId = now_chatId;
        } else {
            the_chatId = chatId;
        }

        RequestBody message = RequestBody.create(MediaType.parse("text/plain"), binding.edtMessage.getText().toString());
        RequestBody receiver_Id = RequestBody.create(MediaType.parse("text/plain"), receiverId);
        RequestBody chat_Id = RequestBody.create(MediaType.parse("text/plain"), the_chatId);

        fields.put("message", message);
        fields.put("receiver_id", receiver_Id);//these keys must be same which we get from api.
        fields.put("chat_id", chat_Id);

        return fields;
    }

    private void callSendIndividualChatApi() {

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
            profile_body = RequestBody.create(MediaType.parse("image"), fileFlyer);
            profilePart = MultipartBody.Part.createFormData("image", fileFlyer.getName(), profile_body);
        } else {
            profile_body = RequestBody.create(MediaType.parse("image"), "");
            profilePart = MultipartBody.Part.createFormData("image", "", profile_body);
        }
        //end multipart image


        /*Call<SendIndividualChatModel> call = apiInterface
                .getSendIndividualMessageResult(map,
                        binding.edtMessage.getText().toString(), receiverId, chatId);*/


        //calling header token,multipart data,multipart image
        Call<SendIndividualChatModel> call =
                apiInterface.getSendIndividualMessageResult(map, setUpMapData(), profilePart);

        call.enqueue(new Callback<SendIndividualChatModel>() {
            @Override
            public void onResponse(Call<SendIndividualChatModel> call, Response<SendIndividualChatModel> response) {
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //to get all response here,
                        // Toast.makeText(IndividualChatDetail.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                        //when we sent message it means we only add message(i.e append) on this list.

                        //if message sent then in logcat print sent=1 and do isMessageSent = true.it also go on individualChatDetailAdapter.addItem if individualChatDetailAdapter not null
                        //it means, in logcat print sent=2 but we have done isMessageSent = false.so message will not be sent.
                        //only at the time of message sent successfully,we do isMessageSent = true otherwise isMessageSent = false.

                        isMessageSent = true;
                        Log.w("send", "1");

                        IndividualMessageDetailsResponse individualMessageDetailsResponse = response.body().getSendResponse();
                        //first time chatId meet null bcz we did't chat with anyone,so if we didn't chat with anyone we send chatId empty.
                        //in backend they don't save bcz chatRoom not made.
                        //again after hiting send api,we get chatId then chatId will not meet blank again.
                        //chatId get from this response we must have to send in this SendIndividualMessage api.
                        //we cann't send blank after 1st time,so chatId with one same senderId,receiverId will always same.

                        IndividualChatDetail.this.chatId = individualMessageDetailsResponse.getChat_id();
                        IndividualChatDetail.this.now_chatId = individualMessageDetailsResponse.getChat_id();
                        //to empty message box
                        binding.edtMessage.setText("");
                        //to hide keyboard
                        HelperClass.hideSoftKeyBoard(IndividualChatDetail.this);

                        if (individualChatDetailAdapter != null) {
                            //push notification comes only once, above
                            //message append at 2 times on this list
                            //1.add(append) item after sending message while instant chat, which we get response from individualMessageDetailsResponse
                            //2.add(append) item when get push from firebase using response bean

                            //when we send messages we instantly add item automatically
                            individualChatDetailAdapter.addItem(individualMessageDetailsResponse);
                            //to get latest array list of adapter and assign in senderReceiverList while instant chat
                            //because we need to latest list(senderReceiverList) to scroll automatically
                            senderReceiverList = individualChatDetailAdapter.getArrayList();
                            //to scroll up automatically
                            binding.recyclerViewSenderReceiver.scrollToPosition(senderReceiverList.size() - 1);

                            isMessageSent = false;
                            Log.w("send", "2");

                        } else {
                            //first time we send the message then individualChatDetailAdapter will found null,so it will not go on addItem()
                            //it will come here in else part

                            callIndividualChatDetailApi();
                            Log.w("send", "3");
                        }

                    } else {
                        isMessageSent = false;
                        Log.w("send", "4");
                        //Toast.makeText(IndividualChatDetail.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                } else {
                    // to see server error in logcat
                    Toast.makeText(IndividualChatDetail.this, "server error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SendIndividualChatModel> call, Throwable t) {
                isMessageSent = false;
                MyDialog.getInstance(IndividualChatDetail.this).hideDialog();
            }
        });

    }
}
