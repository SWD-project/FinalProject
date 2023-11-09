package com.example.finalproject.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject.api.course.CourseRepository;
import com.example.finalproject.api.course.CourseService;
import com.example.finalproject.constants.Category;
import com.example.finalproject.model.dto.CourseSearchRequest;
import com.example.finalproject.model.dto.GetCategoryCourseRequest;
import com.example.finalproject.model.dto.GetCategoryCourseResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.entity.Course;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private List<Course> courseCartoonAndComicList = new ArrayList<>();
    private List<Course> courseDigitalList = new ArrayList<>();
    private List<Course> courseFoundationalList = new ArrayList<>();
    private List<Course> courseSpecializedList = new ArrayList<>();
    private List<Course> courseArtHistoryAndTheoryList = new ArrayList<>();
    private CourseService courseService = CourseRepository.getCourseService();

    public HomeViewModel() {
    }

    public List<Course> getCourseCartoonAndComicList() {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(Category.CARTOON_AND_COMIC));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                if (response.isSuccessful()) {

                    courseCartoonAndComicList.addAll(response.body().getData().get(0).getCourse());
                    Log.i("Course Size", "onResponse" + response.body().getData().get(0).getCourse().size());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {

                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }
        });
        return courseCartoonAndComicList;
    }

    public List<Course> getCourseDigitalList() {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(Category.DIGITAL));
        call.enqueue(new Callback<ResponseBody<GetCategoryCourseResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                if(response.isSuccessful()) {
                    courseDigitalList.addAll(response.body().getData().get(0).getCourse());
                    Log.i("Course Size", "onResponse" + response.body().getData().get(0).getCourse().size());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {
                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }
        });
        return courseDigitalList;
    }

    public List<Course> getCourseFoundationalList() {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(Category.FOUNDATIONAL));
        call.enqueue(new Callback<ResponseBody<GetCategoryCourseResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                if(response.isSuccessful()) {
                    courseFoundationalList.addAll(response.body().getData().get(0).getCourse());

                    Log.i("Course Size", "onResponse" + response.body().getData().get(0).getCourse().size());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {

                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }
        });
        return courseFoundationalList;
    }

    public List<Course> getCourseSpecializedList() {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(Category.SPECIALIZED));
        call.enqueue(new Callback<ResponseBody<GetCategoryCourseResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                courseSpecializedList.addAll(response.body().getData().get(0).getCourse());

                Log.i("Course Size", "onResponse" + response.body().getData().get(0).getCourse().size());
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {

                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }
        });
        return courseSpecializedList;
    }

    public List<Course> getCourseArtHistoryAndTheoryList() {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(Category.ART_HISTORY_AND_THEORY));
        call.enqueue(new Callback<ResponseBody<GetCategoryCourseResponse>>() {

            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                var data = response.body().getData().get(0).getCourse();
                for (var course : data) {
                    courseArtHistoryAndTheoryList.add(course);
                }
                Log.i("Course Size", "onResponse" + courseArtHistoryAndTheoryList.get(0).getTitle());
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {

                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
            }
        });
        Log.i("Course Return Value", "onResponse" + courseArtHistoryAndTheoryList.size());
        return courseArtHistoryAndTheoryList
        ;
    }
}





