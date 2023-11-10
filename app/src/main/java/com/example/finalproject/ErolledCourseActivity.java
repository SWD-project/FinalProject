package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.finalproject.adapter.EnrolledCourseAdapter;
import com.example.finalproject.api.enrolledCourse.EnrolledCourseRepository;
import com.example.finalproject.api.enrolledCourse.EnrolledCourseService;
import com.example.finalproject.model.dto.GetEnrolledCourseRespone;
import com.example.finalproject.model.dto.ResponseBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ErolledCourseActivity extends AppCompatActivity {
    ListView lvEnrolled;
    EnrolledCourseService service;
    List<GetEnrolledCourseRespone> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erolled_course);
        map();
        Call<ResponseBody<GetEnrolledCourseRespone>> call = service.getEnrolledCourse("KG6Wlqo64hSjkFnDsf9MXvTCdMJ3");
        call.enqueue(new Callback<ResponseBody<GetEnrolledCourseRespone>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetEnrolledCourseRespone>> call, Response<ResponseBody<GetEnrolledCourseRespone>> response) {
                ResponseBody<GetEnrolledCourseRespone> x = response.body();
                list = x.getData();
                adapter();
            }

            @Override
            public void onFailure(Call<ResponseBody<GetEnrolledCourseRespone>> call, Throwable t) {

            }
        });
    }
    private void map(){
        service = EnrolledCourseRepository.getEnrolledCourseService();
        lvEnrolled=findViewById(R.id.lv_enrolled_course);
    }
    private void adapter(){
        EnrolledCourseAdapter adapter = new EnrolledCourseAdapter(this, R.layout.activity_enrolled_course_item,list);
        lvEnrolled.setAdapter(adapter);
    }
}