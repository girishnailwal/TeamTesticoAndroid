package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 14/3/18.
 */

public class IndividualMessageDetailsModel {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<IndividualMessageDetailsResponse> individualMessageDetailsResponses;

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

    public List<IndividualMessageDetailsResponse> getIndividualMessageDetailsResponses() {
        return individualMessageDetailsResponses;
    }

    public void setIndividualMessageDetailsResponses(List<IndividualMessageDetailsResponse> individualMessageDetailsResponses) {
        this.individualMessageDetailsResponses = individualMessageDetailsResponses;
    }
}
