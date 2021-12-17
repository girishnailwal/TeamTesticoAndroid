package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 12/2/18.
 */

public class CommonResponse {

    @SerializedName("status_code")
    private String status_code;

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("requestKey")
    private String requestKey;

    @SerializedName("response")
    private AllResponse allResponse;


    public AllResponse getAllResponse() {
        return allResponse;
    }

    public void setAllResponse(AllResponse allResponse) {
        this.allResponse = allResponse;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestKey() {
        return requestKey;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }


}
