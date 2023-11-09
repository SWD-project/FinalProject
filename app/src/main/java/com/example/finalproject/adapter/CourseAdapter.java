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

    public CourseAdapter(Context context, List<Course> courseList ) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.course_row, parent, false);
        return new CourseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        String courseTitle = courseList.get(position).getTitle();
        String courseRating = String.valueOf(courseList.get(position).getPercent());
        String coursePrice = String.valueOf(courseList.get(position).getPrice());



        holder.tvCourseTitle.setText(courseTitle);
        holder.tvCourseRating.setText(courseRating);
        holder.tvCoursePrice.setText(coursePrice);
        holder.ivCourseThumbnail.setImageResource(R.drawable.ic_launcher_background);
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add to cart
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCourseThumbnail;
        TextView tvCourseTitle, tvCourseRating, tvCoursePrice;
        Button btnAddToCart;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            ivCourseThumbnail = itemView.findViewById(R.id.ivCourseThumbnail);
            tvCourseTitle = itemView.findViewById(R.id.tvCourseTitle);
            tvCourseRating = itemView.findViewById(R.id.tvCourseRating);
            tvCoursePrice = itemView.findViewById(R.id.tvCoursePrice);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
