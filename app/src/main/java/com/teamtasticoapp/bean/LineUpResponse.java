package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 28/6/18.
 */

public class LineUpResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("coach_id")
    private String coach_id;

    @SerializedName("name")
    private String name;

    @SerializedName("xcords")
    private String xcords;

    @SerializedName("ycords")
    private String ycords;

    @SerializedName("dress_type")
    private String dress_type;

    @SerializedName("dress_color")
    private String dress_color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXcords() {
        return xcords;
    }

    public void setXcords(String xcords) {
        this.xcords = xcords;
    }

    public String getYcords() {
        return ycords;
    }

    public void setYcords(String ycords) {
        this.ycords = ycords;
    }

    public String getDress_type() {
        return dress_type;
    }

    public void setDress_type(String dress_type) {
        this.dress_type = dress_type;
    }

    public String getDress_color() {
        return dress_color;
    }

    public void setDress_color(String dress_color) {
        this.dress_color = dress_color;
    }

    /* {
        "status_code":"200",
            "status":"SUCCESS",
            "response": [
        {
            "id":1,
                "coach_id":284,
                "name":"Player 1",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":2,
                "coach_id":284,
                "name":"Player 2",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":3,
                "coach_id":284,
                "name":"Player 3",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":4,
                "coach_id":284,
                "name":"Player 4",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":5,
                "coach_id":284,
                "name":"Player 5",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":6,
                "coach_id":284,
                "name":"Player 6",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":7,
                "coach_id":284,
                "name":"Player 7",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":8,
                "coach_id":284,
                "name":"Player 8",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":9,
                "coach_id":284,
                "name":"Player 9",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":10,
                "coach_id":284,
                "name":"Player 10",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        },
        {
            "id":11,
                "coach_id":284,
                "name":"Player 11",
                "xcords":"0.0",
                "ycords":"0.0",
                "dress_type":"1",
                "dress_color":"#FFFFFF",
                "created_at":"2018-06-28 00:00:00",
                "updated_at":"2018-06-28 00:00:00"
        }
  ],
        "message":"Lineup Player List",
            "requestKey":"api\/get_lineup_player"
    }*/

}
