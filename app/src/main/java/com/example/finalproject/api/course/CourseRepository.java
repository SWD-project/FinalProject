package com.example.finalproject.api.course;

import com.example.finalproject.api.APIClient;

public class CourseRepository {
    public static CourseService getCourseService(){
        return APIClient.getClient().create(CourseService.class);
    }
}
