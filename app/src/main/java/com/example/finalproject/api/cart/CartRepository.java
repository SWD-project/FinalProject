package com.example.finalproject.api.cart;

import com.example.finalproject.api.APIClient;

public class CartRepository {
    public static CartService getCartService(){
        return APIClient.getClient().create(CartService.class);
    }
}
