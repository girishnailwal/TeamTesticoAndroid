package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mobulous06 on 9/1/18.
 */

public class FrndJson {

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
