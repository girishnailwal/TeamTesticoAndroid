package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class GroupChatListModel {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<GroupChatListResponse> groupChatListResponses;

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

    public List<GroupChatListResponse> getGroupChatListResponses() {
        return groupChatListResponses;
    }

    public void setGroupChatListResponses(List<GroupChatListResponse> groupChatListResponses) {
        this.groupChatListResponses = groupChatListResponses;
    }
}
