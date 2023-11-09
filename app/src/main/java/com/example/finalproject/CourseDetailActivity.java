package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.api.course.CourseRepository;
import com.example.finalproject.api.course.CourseService;
import com.example.finalproject.model.dto.GetCourseRequest;
import com.example.finalproject.model.dto.GetCourseResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.dto.UserRegistrationRequest;
import com.example.finalproject.model.entity.Course;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.databinding.ActivityCourseDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseDetailActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityCourseDetailBinding binding;
    TextView tvCourseTitle;
    TextView tvCourseDescription;
    TextView tvCourseLecture;
    ListView lvCourseOutcome;
    Button btnAddToCart;
    GetCourseResponse course;
    CourseService courseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCourseDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarCourseDetail.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        map();

        Call<ResponseBody<GetCourseResponse>> call = courseService.getCourse(new GetCourseRequest("65201eb12b4bc7944551a377"));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCourseResponse>> call, Response<ResponseBody<GetCourseResponse>> response) {
                if (response.isSuccessful()) {
                    course = response.body().getData().get(0);
                    tvCourseTitle.setText(course.getTitle());
                    tvCourseDescription.setText(course.getDescription());
                    tvCourseLecture.setText(course.getLectureId().getFirstName() + " " + course.getLectureId().getLastName());
                } else {
                    displayToast("Get course error" + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResponseBody<GetCourseResponse>> call, Throwable t) {
                displayToast("Get course error");
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void map() {
        tvCourseTitle = findViewById(R.id.tvCourseTitle);
        tvCourseDescription = findViewById(R.id.tvCourseDescription);
        tvCourseLecture = findViewById(R.id.tvCourseLecture);
        lvCourseOutcome = findViewById(R.id.lvCourseOutcome);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        courseService = CourseRepository.getCourseService();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_art_history_and_theory) {
            //start activity
            Intent intent = new Intent(this, CategoryActivity.class);
            intent.putExtra("category", "<DB Value>");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}