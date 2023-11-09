package com.example.finalproject.api.course;

import com.example.finalproject.model.dto.CourseSearchRequest;
import com.example.finalproject.model.dto.CourseSearchResponse;
import com.example.finalproject.model.dto.GetCategoryCourseRequest;
import com.example.finalproject.model.dto.GetCategoryCourseResponse;
import com.example.finalproject.model.dto.GetCourseRequest;
import com.example.finalproject.model.dto.GetCourseResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.entity.Course;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CourseService {
    @POST("course/search")
    Call<CourseSearchResponse> searchCourse(@Body CourseSearchRequest courseSearchRequest);

    @POST("course/get-a-course")
    Call<ResponseBody<GetCourseResponse>> getCourse(@Body GetCourseRequest getCourseRequest);

    @POST("category/get-a-category")
    Call<ResponseBody<GetCategoryCourseResponse>> getCategoryCourse(@Body GetCategoryCourseRequest getCategoryCourseRequest);
}
