package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.databinding.FragmentCourseDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {
    private FragmentCourseDetailBinding binding;
    private CourseDetailViewModel courseDetailViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCourseDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //code for setting up views


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}