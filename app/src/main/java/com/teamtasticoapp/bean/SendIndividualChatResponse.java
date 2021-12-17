package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 16/3/18.
 */

public class SendIndividualChatResponse {


    /*{
           "status_code": "200",
            "status": "SUCCESS",
            "response": {
                "sender_id": 172,
                "team_id": "104",
                "message": "Google",
                "receiver_id": "173",
                "chat_id": "84",
                "updated_at": "2018-04-06 14:44:13",
                "created_at": "2018-04-06 14:44:13",
                "id": 203,
                "sender_name": "Abraham",
                "sender_image": "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180327102635118753.jpg",
                "receiver_name": "Anderson",
                "receiver_image": "",
                "message_time": "just now",
                "attachment": ""
           },
          "message": "Sent successfully",
          "requestKey": "api\/send_individual_message"
    }*/

    //send individual

    @SerializedName("sender_id")
    private String sender_id;

    @SerializedName("team_id")
    private String team_id;

    @SerializedName("receiver_id")
    private String receiver_id;

    @SerializedName("chat_id")
    private String chat_id;

    @SerializedName("message")
    private String message;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("id")
    private String id;

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
