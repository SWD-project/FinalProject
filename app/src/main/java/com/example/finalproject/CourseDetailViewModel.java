package com.example.finalproject;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject.api.course.CourseRepository;
import com.example.finalproject.api.course.CourseService;
import com.example.finalproject.model.dto.GetCourseRequest;
import com.example.finalproject.model.dto.GetCourseResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.entity.Course;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseDetailViewModel extends ViewModel {
    private MutableLiveData<GetCourseResponse> course = new MutableLiveData<>();

    private CourseService courseService = CourseRepository.getCourseService();

    public CourseDetailViewModel() {

    }

    public MutableLiveData<GetCourseResponse> getCourse(String id, MutableLiveData<GetCourseResponse> course) {
        var call = courseService.getCourse(new GetCourseRequest(id));
        call.enqueue(new Callback<ResponseBody<GetCourseResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCourseResponse>> call, Response<ResponseBody<GetCourseResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i("Fetch Success", "onResponse: " + response.body().getData().get(0));
                    var data = response.body().getData().get(0);
                    course.postValue(data);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCourseResponse>> call, Throwable t) {
                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }

        });
        return course;
    }

    public LiveData<GetCourseResponse> getCourseResponseLiveData(String id){
        getCourse(id, course);
        return course;
    }
}
