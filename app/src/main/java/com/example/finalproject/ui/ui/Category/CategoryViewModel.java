package com.example.finalproject.ui.ui.Category;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalproject.api.course.CourseRepository;
import com.example.finalproject.api.course.CourseService;
import com.example.finalproject.constants.Category;
import com.example.finalproject.model.dto.GetCategoryCourseRequest;
import com.example.finalproject.model.dto.GetCategoryCourseResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.entity.Course;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<Course>> liveDataCourseCartoonAndComicList = new MutableLiveData<>();
    private MutableLiveData<List<Course>> liveDataCourseDigitalList = new MutableLiveData<>();
    private MutableLiveData<List<Course>> liveDataCourseFoundationalList = new MutableLiveData<>();
    private MutableLiveData<List<Course>> liveDataCourseSpecializedList = new MutableLiveData<>();
    private MutableLiveData<List<Course>> liveDataCourseArtHistoryAndTheoryList = new MutableLiveData<>();

    private boolean isLoadingCartoonAndComic = false;
    private boolean isLoadingDigital = false;
    private boolean isLoadingFoundational = false;
    private boolean isLoadingSpecialized = false;
    private boolean isLoadingArtHistoryAndTheory = false;

    private CourseService courseService = CourseRepository.getCourseService();

    public CategoryViewModel() {

    }
    public LiveData<List<Course>> getLiveDataCourseCartoonAndComicList() {
        loadCoursesByCategory(Category.CARTOON_AND_COMIC, liveDataCourseCartoonAndComicList);
        return liveDataCourseCartoonAndComicList;
    }

    public LiveData<List<Course>> getLiveDataCourseDigitalList() {
        loadCoursesByCategory(Category.DIGITAL, liveDataCourseDigitalList);
        return liveDataCourseDigitalList;
    }

    public LiveData<List<Course>> getLiveDataCourseFoundationalList() {
        loadCoursesByCategory(Category.FOUNDATIONAL, liveDataCourseFoundationalList);
        return liveDataCourseFoundationalList;
    }

    public LiveData<List<Course>> getLiveDataCourseSpecializedList() {
        loadCoursesByCategory(Category.SPECIALIZED, liveDataCourseSpecializedList);
        return liveDataCourseSpecializedList;
    }

    public LiveData<List<Course>> getLiveDataCourseArtHistoryAndTheoryList() {
        loadCoursesByCategory(Category.ART_HISTORY_AND_THEORY, liveDataCourseArtHistoryAndTheoryList);
        return liveDataCourseArtHistoryAndTheoryList;
    }

    private void loadCoursesByCategory(String category, MutableLiveData<List<Course>> liveDataList) {
        var call = courseService.getCategoryCourse(new GetCategoryCourseRequest(category));
        call.enqueue(new Callback<ResponseBody<GetCategoryCourseResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCategoryCourseResponse>> call, Response<ResponseBody<GetCategoryCourseResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Course> courses = response.body().getData().get(0).getCourse();
                    liveDataList.postValue(courses);
                } else {
                    // Handle the case where the response is not successful or the body is null
                    liveDataList.postValue(new ArrayList<>()); // Post an empty list or null
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCategoryCourseResponse>> call, Throwable t) {
                Log.i("Fetch Failed", "onFailure: " + t.getMessage());
                liveDataList.postValue(null); // Post null or some error indicator
            }
        });
    }
    public LiveData<List<Course>> getLiveDataByCategory(String category) {
        switch (category) {
            case Category.CARTOON_AND_COMIC:
                return getLiveDataCourseCartoonAndComicList();
            case Category.DIGITAL:
                return getLiveDataCourseDigitalList();
            case Category.FOUNDATIONAL:
                return getLiveDataCourseFoundationalList();
            case Category.SPECIALIZED:
                return getLiveDataCourseSpecializedList();
            case Category.ART_HISTORY_AND_THEORY:
                return getLiveDataCourseArtHistoryAndTheoryList();
            default:
                return new MutableLiveData<>();
        }
    }

}