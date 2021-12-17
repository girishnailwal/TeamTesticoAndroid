package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 8/6/18.
 */

public class EventListModel {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<EventListResponse> eventListResponses;

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

    public List<EventListResponse> getEventListResponses() {
        return eventListResponses;
    }

    public void setEventListResponses(List<EventListResponse> eventListResponses) {
        this.eventListResponses = eventListResponses;
    }
}
