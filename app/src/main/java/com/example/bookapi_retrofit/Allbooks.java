package com.example.bookapi_retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Allbooks {

    @SerializedName("items")
    List<Itemss> items;


    public Allbooks(List<Itemss> items){
        this.items=items;
    }
    public List<Itemss> getItems(){
        return items;
    }

}

