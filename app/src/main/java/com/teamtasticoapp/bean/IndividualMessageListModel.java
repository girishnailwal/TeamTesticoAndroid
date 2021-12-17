package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 13/3/18.
 */

public class IndividualMessageListModel {
    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @SerializedName("response")
    private List<IndividualMessageListResponse> individualMessageListResponses;

    public List<IndividualMessageListResponse> getIndividualMessageListResponses() {
        return individualMessageListResponses;
    }

    public void setIndividualMessageListResponses(List<IndividualMessageListResponse> individualMessageListResponses) {
        this.individualMessageListResponses = individualMessageListResponses;
    }
}
