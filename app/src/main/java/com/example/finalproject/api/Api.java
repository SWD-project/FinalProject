package com.example.finalproject.api;

import com.example.finalproject.model.UserRegistrationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("user/create-user")
    Call<UserRegistrationRequest> createUser(@Body UserRegistrationRequest userRegistrationRequest);
}
