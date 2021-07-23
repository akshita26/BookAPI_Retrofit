package com.example.bookapi_retrofit;

import com.google.gson.annotations.SerializedName;

public class Imagelinkss {

    @SerializedName("thumbnail")
    String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public Imagelinkss(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
