package com.example.finalproject.model.dto;

public class AddToCartRequest {
    private String courseId;

    public AddToCartRequest() {
    }

    public AddToCartRequest(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
