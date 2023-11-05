package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

public class CourseSearchResponse {
    private Course[] courses;
    private int total;

    public CourseSearchResponse(Course[] courses, int total) {
        this.courses = courses;
        this.total = total;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
