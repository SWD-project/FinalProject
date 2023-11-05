package com.example.finalproject.api.course;

import com.example.finalproject.model.dto.CourseSearchRequest;
import com.example.finalproject.model.dto.CourseSearchResponse;
import com.example.finalproject.model.entity.Course;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CourseService {
    @POST("course/search")
    Call<CourseSearchResponse> searchCourse(@Body CourseSearchRequest courseSearchRequest);
}
