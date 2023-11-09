package com.example.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.entity.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    Context context;
    List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View contactView = layoutInflater.inflate(R.layout.course_row, parent, false);
        return new CourseAdapter.ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.tvCourseTitle.setText(courseList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseTitle, tvCourseDiscount, tvOriginalPrice, tvDiscountedPrice, tvCourseRating, tvRatingCount;
        ImageView ivCourseThumbnail;
        Button btnAddToCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseTitle = itemView.findViewById(R.id.tvCourseTitle);
            tvCourseDiscount = itemView.findViewById(R.id.tvDiscountLabel);
            tvOriginalPrice = itemView.findViewById(R.id.tvOriginalPrice);
            tvCourseRating = itemView.findViewById(R.id.tvCourseRating);
            tvRatingCount = itemView.findViewById(R.id.tvRatingCount);
            ivCourseThumbnail = itemView.findViewById(R.id.ivCourseThumbnail);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
