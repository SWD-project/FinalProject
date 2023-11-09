package com.example.finalproject.api.enrolledCourse;


import com.example.finalproject.model.dto.GetEnrolledCourseRespone;
import com.example.finalproject.model.dto.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface EnrolledCourseService {
    @POST("enrolled-course/get")
    Call<ResponseBody<GetEnrolledCourseRespone>> getTransaction(@Header("Authorization") String uuid, @Body GetEnrolledCourseRespone respone );

}
