package com.example.bookapi_retrofit;

import com.google.gson.annotations.SerializedName;

public class Itemss {
    @SerializedName("volumeInfo")
    VolInfo volInfo;

    public VolInfo getVolInfo(){
        return volInfo;
    }

    public class VolInfo{
        @SerializedName("title")
        String title;

        @SerializedName("authors")
        String[] authors;

        @SerializedName("imageLinks")
        Imagelinkss imagelinkss;

        public VolInfo(String title,String[] authors){
            this.title=title;
            this.authors=authors;
        }

        public String getTitle(){
            return title;
        }

        public String[] getAuthors(){
            return authors;
        }
        public Imagelinkss getImagelinkss(){
            return imagelinkss;
        }
    }
}
