package com.example.finalproject.api.user;

import com.example.finalproject.model.dto.UserRegistrationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("user/create-user")
    Call<UserRegistrationRequest> createUser(@Body UserRegistrationRequest userRegistrationRequest);
}
