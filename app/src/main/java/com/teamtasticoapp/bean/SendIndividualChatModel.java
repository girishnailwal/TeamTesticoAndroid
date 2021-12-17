package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 16/3/18.
 */

public class SendIndividualChatModel {

    @SerializedName("status_code")
    private String status_code;

    @SerializedName("status")
    private String status;

    @SerializedName("requestKey")
    private String requestKey;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private IndividualMessageDetailsResponse sendResponse;

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IndividualMessageDetailsResponse getSendResponse() {
        return sendResponse;
    }

    public void setSendResponse(IndividualMessageDetailsResponse sendResponse) {
        this.sendResponse = sendResponse;
    }
}
