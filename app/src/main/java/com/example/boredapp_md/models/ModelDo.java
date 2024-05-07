package com.example.boredapp_md.models;

import com.google.gson.annotations.SerializedName;

public class ModelDo {
    @SerializedName("key")
    private String key;
    @SerializedName("activity")
    private String activity;
    @SerializedName("price")
    private double price;
    @SerializedName("link")
    private String link;
    @SerializedName("participants")
    private String participants;
    @SerializedName("type")
    private String type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
