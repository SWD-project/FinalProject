package com.example.finalproject.model.dto;

import com.example.finalproject.model.entity.Course;

import java.util.List;

public class GetCategoryCourseResponse {
    private String _id;
    private String name;
    private List<Course> course;
    private int total;

    public GetCategoryCourseResponse(String _id, String name, List<Course> course, int total) {
        this._id = _id;
        this.name = name;
        this.course = course;
        this.total = total;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public int getTotal() {
        return total;
    }
}
