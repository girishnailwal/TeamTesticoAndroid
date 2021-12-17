package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mobulous55 on 26/6/18.
 */

public class PlayerLineupModel implements Serializable{

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("response")
    private List<PlayerLineupResponse> playerLineupResponses;

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

    public List<PlayerLineupResponse> getPlayerLineupResponses() {
        return playerLineupResponses;
    }

    public void setPlayerLineupResponses(List<PlayerLineupResponse> playerLineupResponses) {
        this.playerLineupResponses = playerLineupResponses;
    }
}
