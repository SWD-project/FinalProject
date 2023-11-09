package com.example.finalproject.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.CourseDetailsActivity;
import com.example.finalproject.adapter.CourseAdapter;
import com.example.finalproject.constants.Category;
import com.example.finalproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Setup RecyclerViews
        setupRecyclerView(binding.rvCartoonAndComic, Category.CARTOON_AND_COMIC);
        setupRecyclerView(binding.rvDigital, Category.DIGITAL);
        setupRecyclerView(binding.rvFoundational, Category.FOUNDATIONAL);
        setupRecyclerView(binding.rvSpecialized, Category.SPECIALIZED);
        setupRecyclerView(binding.rvArtHistoryAndTheory, Category.ART_HISTORY_AND_THEORY);

        return root;
    }

    private void setupRecyclerView(RecyclerView recyclerView, String category) {
        CourseAdapter courseAdapter = new CourseAdapter(getContext(), new ArrayList<>());
        courseAdapter.setOnClickListener((view, position) -> {
            Intent intent = new Intent(getContext(), CourseDetailsActivity.class);
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(courseAdapter);

        // Observe the LiveData from the ViewModel based on the category
        // Update adapter's data
        homeViewModel.getLiveDataByCategory(category).observe(getViewLifecycleOwner(), courseAdapter::updateCourses);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    


}
