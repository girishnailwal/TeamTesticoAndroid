package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 28/6/18.
 */

public class LineUpModel {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<LineUpResponse> lineUpResponses;

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

    public List<LineUpResponse> getLineUpResponses() {
        return lineUpResponses;
    }

    public void setLineUpResponses(List<LineUpResponse> lineUpResponses) {
        this.lineUpResponses = lineUpResponses;
    }
}
