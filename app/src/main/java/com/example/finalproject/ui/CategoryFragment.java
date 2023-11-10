package com.example.finalproject.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.CategoryViewModel;
import com.example.finalproject.CourseDetailViewModel;
import com.example.finalproject.CourseDetailsActivity;
import com.example.finalproject.R;
import com.example.finalproject.adapter.CourseAdapter;
import com.example.finalproject.constants.Category;
import com.example.finalproject.databinding.FragmentCategoryBinding;
import com.example.finalproject.databinding.FragmentCourseDetailBinding;
import com.example.finalproject.ui.home.HomeViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding binding;
    private HomeViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        categoryViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String categoryId = getActivity().getIntent().getStringExtra("category");
        String categoryHeading = getActivity().getIntent().getStringExtra("header");

        TextView tvCategoryHeading = binding.tvCategoryHeading;
        tvCategoryHeading.setText(categoryHeading);

        //code for setting up views
        setupRecyclerView(binding.rvCourseCategory, categoryId);


        return root;
    }

    private void setupRecyclerView(RecyclerView recyclerView, String category) {
        CourseAdapter courseAdapter = new CourseAdapter(
                getContext(),
                new ArrayList<>()
        );
        courseAdapter.setOnClickListener((view, position) -> {
            Intent intent = new Intent(getContext(), CourseDetailsActivity.class);
            intent.putExtra("courseId", courseAdapter.getCourses().get(position).get_id());
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(courseAdapter);

        categoryViewModel.getLiveDataByCategory(category).observe(getViewLifecycleOwner(),
                courseAdapter::updateCourses
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}