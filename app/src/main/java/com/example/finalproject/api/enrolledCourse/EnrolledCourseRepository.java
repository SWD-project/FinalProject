package com.example.finalproject.api.enrolledCourse;

import com.example.finalproject.api.APIClient;

public class EnrolledCourseRepository {
    public static EnrolledCourseService getEnrolledCourseService(){
        return APIClient.getClient().create(EnrolledCourseService.class);
    }
}
