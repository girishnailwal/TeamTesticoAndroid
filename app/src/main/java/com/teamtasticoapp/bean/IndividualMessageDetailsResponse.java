package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 14/3/18.
 */

public class IndividualMessageDetailsResponse {

    /* {
             "status_code":"200",
             "status":"SUCCESS",
             "response":{
                 "sender_id":136,
                 "team_id":"87",
                 "message":"ho",
                 "receiver_id":"139",
                 "chat_id":"46",
                 "updated_at":"2018-03-23 06:09:01",
                 "created_at":"2018-03-23 06:09:01",
                 "id":72,
                 "image":"http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180320141929109425.jpg",
                 "name":"Rahul"
                 },
         "message":"Sent successfully",
         "requestKey":"api\/send_individual_message"
     }*/



   /*    {
             "status_code":"200",
             "status":"SUCCESS",
             "response":{
                    "sender_id":139,
                    "team_id":"87",
                    "message":"hi Sachin",
                    "receiver_id":"136",
                    "chat_id":"43",
                    "updated_at":"2018-03-23 07:46:05",
                    "created_at":"2018-03-23 07:46:05",
                    "id":77,
                    "sender_name":"Rahul",
                    "sender_image":
                    "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180320141929109425.jpg",
                    "receiver_name":"Sachin",
                    "receiver_image":
                    "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180320133250910656.jpg",
                    "message_time":"just now"
            },
        "message":"Sent successfully",
        "requestKey":"api\/send_individual_message"
      }
*/

    @SerializedName("chat_id")
    private String chat_id;

    @SerializedName("sender_id")
    private String sender_id;

    @SerializedName("sender_name")
    private String sender_name;

    @SerializedName("sender_image")
    private String sender_image;

    @SerializedName("receiver_id")
    private String receiver_id;

    @SerializedName("receiver_name")
    private String receiver_name;

    @SerializedName("receiver_image")
    private String receiver_image;

    @SerializedName("message")
    private String message;

    @SerializedName("message_time")
    private String message_time;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("attachment")
    private String attachment;

    @SerializedName("type")
    private String type;

    @SerializedName("message_id")
    private String message_id;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_image() {
        return sender_image;
    }

    public void setSender_image(String sender_image) {
        this.sender_image = sender_image;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_image() {
        return receiver_image;
    }

    public void setReceiver_image(String receiver_image) {
        this.receiver_image = receiver_image;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
