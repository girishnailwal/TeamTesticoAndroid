package com.teamtasticoapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mobulous55 on 23/2/18.
 */

public class AllResponse {

    //create_team
    @SerializedName("team_name")
    private String team_name;

    @SerializedName("team_code")
    private String team_code;

    @SerializedName("team_id")
    private String team_id;

    @SerializedName("token")
    private String token;

    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_code() {
        return team_code;
    }

    public void setTeam_code(String team_code) {
        this.team_code = team_code;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    //team_list
    @SerializedName("team_member")
    private List<TeamMemberResponse> teamMemberResponseList;

    public List<TeamMemberResponse> getTeamMemberResponseList() {
        return teamMemberResponseList;
    }

    public void setTeamMemberResponseList(List<TeamMemberResponse> teamMemberResponseList) {
        this.teamMemberResponseList = teamMemberResponseList;
    }

    //login
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("position")
    private String position;

    @SerializedName("device_id")
    private String device_id;

    @SerializedName("device_type")
    private String device_type;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
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


    //check_team_code
    @SerializedName("coach_id")
    private String coach_id;

    public String getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(String coach_id) {
        this.coach_id = coach_id;
    }


    //join_team
    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    //profile
    @SerializedName("image")
    private String image;

    @SerializedName("is_admin")
    private String is_admin;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    //edit profile

    //Individual_message

    //User_list

    //playerinLineup





}
