package com.example.finalproject.api.cart;

import com.example.finalproject.model.dto.AddToCartRequest;
import com.example.finalproject.model.dto.AddToCartResponse;
import com.example.finalproject.model.dto.CheckoutRequest;
import com.example.finalproject.model.dto.CheckoutResponse;
import com.example.finalproject.model.dto.GetCartResponse;
import com.example.finalproject.model.dto.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CartService {

    @POST("cart/get-a-cart")
    Call<ResponseBody<GetCartResponse>> getCart(@Header("Authorization") String authHeader);

    @POST("cart-detail/create")
    Call<ResponseBody<AddToCartResponse>> AddToCart(@Header("Authorization") String authHeader, @Body AddToCartRequest request);

    @POST("user/checkout")
    Call<ResponseBody<CheckoutResponse>> checkout(@Header("Authorization") String authHeader, @Body CheckoutRequest request);
}
