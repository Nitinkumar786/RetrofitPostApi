package com.example.postapi;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private Integer Id;
    private String title;

    public String getText() {
        return text;
    }

    public Post(int userId, Integer id, String title, String text) {
        this.userId = userId;
        this.Id = id;
        this.title = title;
        this.text = text;
    }

    @SerializedName("body")


    private  String text;



    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }


}
