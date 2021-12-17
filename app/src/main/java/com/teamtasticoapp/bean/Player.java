package com.teamtasticoapp.bean;

public class Player {
    private int id;
    private String name;
    private float xcords;
    private float ycords;

    public Player(int id, String name, float xcords, float ycords) {
        this.id = id;
        this.name = name;
        this.xcords = xcords;
        this.ycords = ycords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getXcords() {
        return xcords;
    }

    public void setXcords(float xcords) {
        this.xcords = xcords;
    }

    public float getYcords() {
        return ycords;
    }

    public void setYcords(float ycords) {
        this.ycords = ycords;
    }
}
