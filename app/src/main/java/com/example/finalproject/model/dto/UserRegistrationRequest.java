package com.example.finalproject.model.dto;

public class UserRegistrationRequest {
    private String firstName;
    private String lastName;
    private String roleId;
    private String email;
    private String uuid;

    public UserRegistrationRequest(String firstName, String lastName,String roleId, String email, String uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
        this.email = email;
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
