package com.example.finalproject.model;

public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String uuid;

    public UserRegistrationRequest(String firstName, String lastName, String email, String uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.uuid = uuid;
    }
}
