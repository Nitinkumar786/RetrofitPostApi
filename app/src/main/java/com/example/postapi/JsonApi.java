package com.example.postapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonApi {

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
