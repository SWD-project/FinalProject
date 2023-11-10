package com.example.finalproject.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.CategoryViewModel;
import com.example.finalproject.CourseDetailViewModel;
import com.example.finalproject.R;
import com.example.finalproject.constants.Category;
import com.example.finalproject.databinding.FragmentCategoryBinding;
import com.example.finalproject.databinding.FragmentCourseDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding binding;
    private CategoryViewModel categoryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //code for setting up views
        setupRecyclerView(binding.rvCartoonAndComic, Category.CARTOON_AND_COMIC);
        


        return root;
    }

    private void setupRecyclerView(RecyclerView rvCartoonAndComic, String cartoonAndComic) {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}