package com.teamtasticoapp.fcm;

/**
 * Created by mobulous2 on 3/3/17.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.teamtasticoapp.R;
import com.teamtasticoapp.activity.IndividualChatDetail;
import com.teamtasticoapp.activity.TeamPageHome;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.fragment.GroupChatFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;

//Sender Activity
//The activity that sends/broadcasts notifications.

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    // Called when message is received.@param remoteMessage Object representing the message received from Firebase Cloud Messaging.
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) // Check if message contains a notification payload.
        {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        if (remoteMessage.getData().size() > 0) // Check if message contains a data payload.
        {
            String type = "", message = "", chat_id = "";
            try {
                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                Map<String, String> data = remoteMessage.getData();
                JSONObject jsonObject = new JSONObject(data);
                type = jsonObject.getString("type");

                String isLogin = SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.currentLogin);
                if (isLogin.equalsIgnoreCase("true")) {

                    //if this first if statement will be true,then it will not go on else if,
                    //whether else if would be true,

                    //if this first if statement will not be true,then it will go on else if

                    //foreground
                    if (TeamPageHome.isTeamHomeOnForeground) {

                        if (GroupChatFragment.isGroupChatFragmentOnForeground) {
                            if ("group_message".equalsIgnoreCase(type)) {

                                Bundle bundle = makeGroupBundle(jsonObject);
                                // Send an Intent with an action named "PUSH_CHAT".
                                // The Intent sent should be received by the ReceiverActivity.
                                // Log.d("sender", "Broadcasting message");
                                Intent intent = new Intent("PUSH_CHAT");
                                // You can also include some extra data.
                                intent.putExtras(bundle);
                                //way to send broadcast
                                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                            }
                            //background
                        } else {
                            if ("individual_message".equalsIgnoreCase(type)) {
                                Bundle bundle = makeIndividualBundle(jsonObject);
                                sendNotificationWithIndividual(bundle);

                            } else if ("group_message".equalsIgnoreCase(type)) {
                                Bundle bundle = makeGroupBundle(jsonObject);
                                sendNotificationWithGroup(bundle);
                            } else {
                                // Bundle bundle = makeGroupBundle(jsonObject);
                                // sendNotificationWithGroup(bundle);
                            }
                        }


                    } else if (IndividualChatDetail.isIndividualChatOnForeground) {

                        if ("individual_message".equalsIgnoreCase(type)) {
                            Bundle bundle = makeIndividualBundle(jsonObject);
                            Intent intent = new Intent("PUSH_CHAT");
                            intent.putExtras(bundle);
                            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

                            //sendNotification(makeIndividualBundle(jsonObject));
                        }

                    } else {
                        if ("individual_message".equalsIgnoreCase(type)) {
                            Bundle bundle = makeIndividualBundle(jsonObject);
                            sendNotificationWithIndividual(bundle);
                        } else if ("group_message".equalsIgnoreCase(type)) {
                            Bundle bundle = makeGroupBundle(jsonObject);
                            sendNotificationWithGroup(bundle);
                        } else {
                            // Bundle bundle = makeGroupBundle(jsonObject);
                            // sendNotificationWithGroup(bundle);
                        }

                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    // Also if you intend on generating your own notifications as a result of a received FCM
    // message, here is where that should be initiated. See sendNotification method below.

    private Bundle makeGroupBundle(JSONObject jsonObject) {

         /*{
             type=group_message,
             batch=[],
             sound=default,
             message=tfsdfst

           }*/


       /*  Messagedatapayload: {
                  type=group_message,
                  batch={
                          "attachment": "http:\/\/mobulous.co.in\/teamtastico\/public\/attachment\/20180404102747170224.jpg"
                        },
                  sound=default,
                  message=
        }*/

        Bundle bundle = new Bundle();

        String type = "";
        String message = "";
        String attachmentImg = "";

        try {
            type = jsonObject.getString("type");
            message = jsonObject.getString("message");

            String batch = jsonObject.getString("batch");
            JSONObject batchJson = new JSONObject(batch);

            attachmentImg = batchJson.getString("attachment");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        bundle.putString("type", type);
        bundle.putString("message", message);
        bundle.putString("attachment", attachmentImg);

        bundle.putString("from", "fcm");

        return bundle;
    }


    private Bundle makeIndividualBundle(JSONObject jsonObject) {

        /*{
           type=individual_message,
           batch={
                 "receiver_id": "149",
                 "created_at": "2018-03-23 13:18:38",
                 "sender_name": "Qwerty",
                 "receiver_image": "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180323092059930486.jpg",
                 "team_id": "93",
                 "message": "ghhh",
                 "sender_id": 148,
                 "chat_id": "47",
                 "message_time": "just now",
                "updated_at": "2018-03-23 13:18:38",
                "sender_image": "",
                "receiver_name": "Josef",
                "id": 61
               },
         sound=default,
         message=ghhh
     }*/


      /*  {
            type=individual_message,
            batch={
                "image": "20180404102016781396.jpg",
                "receiver_id": "172",
                "created_at": "2018-04-04 10:20:16",
                "sender_name": "Anderson",
                "receiver_image": "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180327102635118753.jpg",
                "team_id": "104",
                "message": null,
                "sender_id": 173,
                "chat_id": "84",
                "message_time": "just now",
                "updated_at": "2018-04-04 10:20:16",
                "sender_image": "",
                "attachment": "http:\/\/mobulous.co.in\/teamtastico\/public\/attachment\/20180404102016781396.jpg",
                "receiver_name": "Abraham",
                "id": 109
                },
            sound=default,
            message=
        }*/


        Bundle bundle = new Bundle();

        String type = "";
        String message = "";

        String id = "";
        String team_id = "";
        String chat_id = "";
        String created_at = "";
        String message_time = "";

        String sender_id = "";
        String sender_name = "";
        String sender_image = "";

        String receiver_id = "";
        String receiver_name = "";
        String receiver_image = "";
        String attachmentImg = "";


        try {
            type = jsonObject.getString("type");
            message = jsonObject.getString("message");

            String batch = jsonObject.getString("batch");
            JSONObject batchJson = new JSONObject(batch);

            team_id = batchJson.getString("team_id");

            chat_id = batchJson.getString("chat_id");

            id = batchJson.getString("id");
            sender_id = batchJson.getString("sender_id");
            receiver_id = batchJson.getString("receiver_id");

            sender_name = batchJson.getString("sender_name");
            sender_image = batchJson.getString("sender_image");

            receiver_name = batchJson.getString("receiver_name");
            receiver_image = batchJson.getString("receiver_image");

            created_at = batchJson.getString("created_at");
            message_time = batchJson.getString("message_time");
            attachmentImg = batchJson.getString("attachment");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        bundle.putString("type", type);
        bundle.putString("message", message);
        bundle.putString("team_id", team_id);

        bundle.putString("chat_id", chat_id);

        bundle.putString("id", id);
        bundle.putString("sender_id", sender_id);
        bundle.putString("receiver_id", receiver_id);

        bundle.putString("sender_image", sender_image);
        bundle.putString("receiver_image", receiver_image);

        bundle.putString("receiver_name", receiver_name);
        bundle.putString("sender_name", sender_name);

        bundle.putString("created_at", created_at);
        bundle.putString("message_time", message_time);

        bundle.putString("attachment", attachmentImg);

        bundle.putString("from", "fcm");


        return bundle;
    }


    private void sendNotificationWithGroup(Bundle bundle) {
        Intent intent = new Intent(this, TeamPageHome.class);

        intent.putExtras(bundle);
        String message = bundle.getString("message");

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
                .setColor(ContextCompat.getColor(MyFirebaseMessagingService.this, R.color.home_header_color))
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(((int) System.currentTimeMillis()) /* ID of notification */, notificationBuilder.build());
        }
    }

    private void sendNotificationWithIndividual(Bundle bundle) {
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
                .setColor(ContextCompat.getColor(MyFirebaseMessagingService.this, R.color.colorPrimary))
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(((int) System.currentTimeMillis()) /* ID of notification */, notificationBuilder.build());
        }
    }

}
//Legacy Server Key
//AIzaSyAKwvmi7OpzxttvsoaixWfzfTXFNm0ITE0


//Legacy Server Key(new)
//AIzaSyAObceL2qH4El6uyAS9lZc5Qx0xC4Pffig

