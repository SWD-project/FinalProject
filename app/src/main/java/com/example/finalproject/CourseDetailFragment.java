package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.adapter.OutcomeAdapter;
import com.example.finalproject.databinding.FragmentCourseDetailBinding;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {
    private FragmentCourseDetailBinding binding;
    private CourseDetailViewModel courseDetailViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        courseDetailViewModel = new ViewModelProvider(this).get(CourseDetailViewModel.class);
        binding = FragmentCourseDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //code for setting up views
        ImageView ivCourseDetailThumbnail = binding.ivCourseDetailThumbnail;
        TextView tvCourseDetailTitle = binding.tvCourseDetailTitle;
        TextView tvCourseDetailDescription = binding.tvCourseDetailDescription;
        TextView tvCourseDetailLecture = binding.tvCourseDetailLecture;
        Button btnAddToCart = binding.btnAddToCart;
        ListView lvOutcomes = binding.lvCourseDetailOutcome;

        Intent intent = getActivity().getIntent();
        String courseId = intent.getStringExtra("courseId");


        courseDetailViewModel.getCourseResponseLiveData(courseId).observe(getViewLifecycleOwner(), course -> {
            if (course != null) {
                tvCourseDetailTitle.setText(course.getTitle());
                tvCourseDetailDescription.setText(course.getDescription());
                tvCourseDetailLecture.setText(course.getLectureId().getFirstName() + " " + course.getLectureId().getLastName());
                OutcomeAdapter outcomeAdapter = new OutcomeAdapter(getContext(), R.layout.outcome_layout, Arrays.asList(course.getOutcome().split("-")));
                lvOutcomes.setAdapter(outcomeAdapter);
            }
        });

        btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Go to cart", Toast.LENGTH_SHORT).show();
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}