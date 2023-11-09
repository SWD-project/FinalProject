package com.example.finalproject.model.dto;

public class GetCourseRequest {
    private String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public GetCourseRequest(String courseId) {
        this.courseId = courseId;
    }
}
