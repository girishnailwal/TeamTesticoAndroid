package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 8/6/18.
 */

public class EventListResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("team_id")
    private String team_id;

    @SerializedName("event_type")
    private String event_type;

    @SerializedName("event_date")
    private String event_date;

    @SerializedName("event_time")
    private String event_time;

    @SerializedName("event_vs")
    private String event_vs;

    @SerializedName("location")
    private String location;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("event_id")
    private String event_id;

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    @SerializedName("team_name")
    private String team_name;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_vs() {
        return event_vs;
    }

    public void setEvent_vs(String event_vs) {
        this.event_vs = event_vs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }
}
