package com.example.finalproject.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.adapter.CourseAdapter;
import com.example.finalproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private CourseAdapter courseAdapterCartoonAndComic;
    private CourseAdapter courseAdapterDigital;
    private CourseAdapter courseAdapterFoundational;
    private CourseAdapter courseAdapterSpecialized;
    private CourseAdapter courseAdapterArtHistoryAndTheory;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView rvCartoonAndComic = binding.rvCartoonAndComic;
        final RecyclerView rvDigital = binding.rvDigital;
        final RecyclerView rvFoundational = binding.rvFoundational;
        final RecyclerView rvSpecialized = binding.rvSpecialized;
        final RecyclerView rvArtHistoryAndTheory = binding.rvArtHistoryAndTheory;

        var courseComicAndCartoonList = homeViewModel.getCourseCartoonAndComicList();
        var courseDigitalList = homeViewModel.getCourseDigitalList();
        var courseFoundationalList = homeViewModel.getCourseFoundationalList();
        var courseSpecializedList = homeViewModel.getCourseSpecializedList();
        var courseArtHistoryAndTheoryList = homeViewModel.getCourseArtHistoryAndTheoryList();

       for (var course : courseComicAndCartoonList) {
           Log.i("HomeFragment", "onCreateView: " + course.getTitle());
       }


        courseAdapterCartoonAndComic = new CourseAdapter(
                getContext(),
                courseComicAndCartoonList
        );

        courseAdapterDigital = new CourseAdapter(
                getContext(),
                courseDigitalList
        );

        courseAdapterFoundational = new CourseAdapter(
                getContext(),
                courseFoundationalList
        );

        courseAdapterSpecialized = new CourseAdapter(
                getContext(),
                courseSpecializedList
        );

        courseAdapterArtHistoryAndTheory = new CourseAdapter(
                getContext(),
                courseArtHistoryAndTheoryList
        );


        rvCartoonAndComic.setAdapter(courseAdapterCartoonAndComic);
        rvDigital.setAdapter(courseAdapterDigital);
        rvFoundational.setAdapter(courseAdapterFoundational);
        rvSpecialized.setAdapter(courseAdapterSpecialized);
        rvArtHistoryAndTheory.setAdapter(courseAdapterArtHistoryAndTheory);

        rvCartoonAndComic.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvDigital.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvFoundational.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvSpecialized.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvArtHistoryAndTheory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}