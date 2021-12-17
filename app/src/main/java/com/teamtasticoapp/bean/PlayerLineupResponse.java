package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous55 on 26/6/18.
 */

public class PlayerLineupResponse {


   /* {
        "status_code": "200",
            "status": "SUCCESS",
            "response": [
        {
            "id": 235,
                "name": "Sehwag",
                "email": "sehwag@gmail.com",
                "position": "Reverse",
                "image": "20180426075828363080.jpg",
                "device_id": "fudbKDRKyC4:APA91bHMLe-pnBHN19NqocLklIZZLuqE943w8qKGYoxCskHEj6bEs1n6BSBj11QY5A9A5L4urcYROU1vDXAkQGmtRWG0b2Feyk1-10Y-q-IN32CUP8RmFpVrdeiNzSSD4odzhB1BgJsRMGtAGis9EzTYwaA7zC61nA",
                "device_type": "android",
                "is_admin": "0",
                "xcords": "505.0",
                "ycords": "272.0",
                "dress_type": "2",
                "dress_color": "ffffff",
                "created_at": "2018-04-26 07:58:29",
                "updated_at": "2018-06-26 06:12:03"
        },
        {
            "id": 259,
                "name": "CK World",
                "email": "test1.enest@gmail.com",
                "position": "Forward",
                "image": "",
                "device_id": "d8qqnAUPMc8:APA91bEWmrL6Kr9l9nc7q0W_TbF935EtQyZEgxJbtswmnTkJV7UkR764NhT52ZNR-fENU2aDXP2xgbBckudy3D_ZEazdcU_jObEniaLjNZAx1_nAR3a8HotNZOd89xmd5KcFwiA_nfG9",
                "device_type": "android",
                "is_admin": "0",
                "xcords": "173.75867",
                "ycords": "364.51678",
                "dress_type": "2",
                "dress_color": "ffffff",
                "created_at": "2018-05-17 09:33:23",
                "updated_at": "2018-06-26 06:12:03"
        },
        {
            "id": 277,
                "name": "Marcus Delpan",
                "email": "marcus@gmail.com",
                "position": "Mid",
                "image": "20180625121353809394.jpg",
                "device_id": "fudbKDRKyC4:APA91bHMLe-pnBHN19NqocLklIZZLuqE943w8qKGYoxCskHEj6bEs1n6BSBj11QY5A9A5L4urcYROU1vDXAkQGmtRWG0b2Feyk1-10Y-q-IN32CUP8RmFpVrdeiNzSSD4odzhB1BgJsRMGtAGis9EzTYwaA7zC61nA",
                "device_type": "android",
                "is_admin": "0",
                "xcords": "390.4577",
                "ycords": "320.55115",
                "dess_color": "ffffff",
                "crress_type": "2",
                "dreated_at": "2018-06-25 12:13:54",
                "updated_at": "2018-06-26 06:12:03"
        }
    ],
        "message": "Player List",
            "requestKey": "api/player_in_lineup"*/

    @SerializedName("id")
    private String id;

    @SerializedName("coach_id")
    private String coach_id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
