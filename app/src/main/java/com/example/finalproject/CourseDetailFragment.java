package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.adapter.OutcomeAdapter;
import com.example.finalproject.api.cart.CartRepository;
import com.example.finalproject.api.cart.CartService;
import com.example.finalproject.databinding.FragmentCourseDetailBinding;
import com.example.finalproject.model.dto.AddToCartRequest;
import com.example.finalproject.model.dto.AddToCartResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CourseDetailFragment extends Fragment {
    private FragmentCourseDetailBinding binding;
    private CourseDetailViewModel courseDetailViewModel;
    private CartService cartService = CartRepository.getCartService();
private FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
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
           addToCart(courseId);
        });


        return root;
    }
    private void addToCart(String courseId) {
        Call<ResponseBody<AddToCartResponse>> call = cartService.AddToCart(mFirebaseAuth.getUid(),new AddToCartRequest(courseId));
        call.enqueue(new Callback<ResponseBody<AddToCartResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<AddToCartResponse>> call, Response<ResponseBody<AddToCartResponse>> response) {
                displayToast("add to cart success");
            }

            @Override
            public void onFailure(Call<ResponseBody<AddToCartResponse>> call, Throwable t) {
                displayToast("add to cart fail");
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void displayToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}