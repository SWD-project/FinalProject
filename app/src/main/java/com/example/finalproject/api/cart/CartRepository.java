package com.example.finalproject.api.cart;

import com.example.finalproject.api.APIClient;
import com.example.finalproject.api.course.CourseService;

public class CartRepository {
    public static CartService getCourseService(){
        return APIClient.getClient().create(CartService.class);
    }
}
