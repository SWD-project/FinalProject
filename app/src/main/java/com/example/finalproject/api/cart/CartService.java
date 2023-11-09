package com.example.finalproject.api.cart;

import com.example.finalproject.model.dto.GetCartResponse;
import com.example.finalproject.model.dto.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CartService {

    @POST("cart/get-a-cart")
    Call<ResponseBody<GetCartResponse>> getCart(@Header("Authorization") String authHeader);
}
