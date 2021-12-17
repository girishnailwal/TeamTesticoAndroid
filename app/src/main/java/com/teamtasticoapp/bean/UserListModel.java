package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mobulous55 on 26/6/18.
 */
//player_in_team api
public class UserListModel implements Serializable {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<UserListResponse> userListResponses;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public List<UserListResponse> getUserListResponses() {
        return userListResponses;
    }

    public void setUserListResponses(List<UserListResponse> userListResponses) {
        this.userListResponses = userListResponses;
    }
}
