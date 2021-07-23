package com.example.bookapi_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface Api {

    String BASE_URL = "https://www.googleapis.com/books/v1/";

    @GET()
    Call<Allbooks> getBook(@Url String url);

}