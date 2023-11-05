package com.example.finalproject.api.user;

import com.example.finalproject.api.APIClient;

public class UserRepository {
    public static UserService getUserService() {
        return APIClient.getClient().create(UserService.class);
    }
}
