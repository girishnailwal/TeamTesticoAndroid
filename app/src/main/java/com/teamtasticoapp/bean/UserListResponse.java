package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mobulous55 on 13/3/18.
 */

//player_in_team api
public class UserListResponse implements Serializable {


    /*    {
           "status_code": "200",
           "status": "SUCCESS",
           "response": [
            {
               "name": "Anderson",
               "image": "",
               "user_id": "173",
               "team_id": "104",
               "chat_id": 84
           },

          {
               "name": "Steve",
               "image": "http:\/\/mobulous.co.in\/teamtastico\/public\/profile_resize\/20180327130717442351.jpg",
               "user_id": "174",
               "team_id": "104",
               "chat_id": 84
         }
       ],
       "message": "List",
       "requestKey": "api\/player_in_team"
    }*/


    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("coach_id")
    private String coach_id;

    @SerializedName("image")
    private String image;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("xcords")
    private String xCords;

    @SerializedName("ycords")
    private String yCords;

    @SerializedName("dress_color")
    private String dressColor;

    @SerializedName("dress_type")
    private String dressType;

    @SerializedName("islineup")
    private String isLineUp;

    @SerializedName("lineup_status")
    private String lineup_status;

    @SerializedName("chat_id")
    private String chat_id;

    @SerializedName("pimage")
    private String pImage;



    public UserListResponse() {
    }

    public UserListResponse(String name, String image, String user_id, String xCords, String yCords, String dressColor, String dressType, String isLineUp, String chat_id,String coach_id, String line_id,String lineup_status,String pimage) {
        this.name = name;
        this.image = image;
        this.user_id = user_id;
        this.xCords = xCords;
        this.yCords = yCords;
        this.dressColor = dressColor;
        this.dressType = dressType;
        this.isLineUp = isLineUp;
        this.chat_id = chat_id;
        this.coach_id = coach_id;
        this.id=line_id;
        this.lineup_status=lineup_status;
        this.pImage=pimage;
    }
    public String getLineup_status() {
        return lineup_status;
    }

    public void setLineup_status(String lineup_status) {
        this.lineup_status = lineup_status;
    }

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
    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getxCords() {
        return xCords;
    }

    public void setxCords(String xCords) {
        this.xCords = xCords;
    }

    public String getyCords() {
        return yCords;
    }

    public void setyCords(String yCords) {
        this.yCords = yCords;
    }

    public String getDressColor() {
        return dressColor;
    }

    public void setDressColor(String dressColor) {
        this.dressColor = dressColor;
    }

    public String getDressType() {
        return dressType;
    }

    public void setDressType(String dressType) {
        this.dressType = dressType;
    }

    public String getIsLineUp() {
        return isLineUp;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public void setIsLineUp(String isLineUp) {
        this.isLineUp = isLineUp;


    }
}
