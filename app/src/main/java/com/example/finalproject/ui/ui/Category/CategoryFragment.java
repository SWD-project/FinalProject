package com.example.finalproject.ui.ui.Category;

import android.os.Bundle;
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
import com.example.finalproject.constants.Category;
import com.example.finalproject.databinding.FragmentCategoryBinding;
import com.example.finalproject.databinding.FragmentHomeBinding;
import com.example.finalproject.ui.home.HomeViewModel;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;
    private CategoryViewModel categoryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel  = new ViewModelProvider(this).get(CategoryViewModel.class);
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        setupRecyclerView(binding.action_cartoon_and_comic, Category.CARTOON_AND_COMIC);
        setupRecyclerView(binding.rvDigital, Category.DIGITAL);
        setupRecyclerView(binding.rvFoundational, Category.FOUNDATIONAL);
        setupRecyclerView(binding.rvSpecialized, Category.SPECIALIZED);
        setupRecyclerView(binding.rvArtHistoryAndTheory, Category.ART_HISTORY_AND_THEORY);
        return root;

    }
    private void setupRecyclerView(RecyclerView recyclerView, String category) {
        CourseAdapter courseAdapter = new CourseAdapter(getContext(), new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(courseAdapter);

        // Observe the LiveData from the ViewModel based on the category
        // Update adapter's data
        categoryViewModel.getLiveDataByCategory(category).observe(getViewLifecycleOwner(), courseAdapter::updateCourses);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}