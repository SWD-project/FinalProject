package com.example.finalproject.api.cart;

import com.example.finalproject.model.dto.CourseSearchRequest;
import com.example.finalproject.model.dto.CourseSearchResponse;
import com.example.finalproject.model.dto.GetCartResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CartService {

    @POST("cart/get-a-cart")
    Call<GetCartResponse[]> getCart(@Header("Authorization") String authHeader);
}
