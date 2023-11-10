package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.finalproject.constants.Category;
import com.example.finalproject.databinding.ActivityHomePageBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHomePage.toolbar);
        setupNavigation();
    }

    private void setupNavigation() {
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
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
            startCategoryActivity(Category.ART_HISTORY_AND_THEORY, "Art History and Theory");
        } else if (item.getItemId() == R.id.action_foundational) {
            //start activity
            startCategoryActivity(Category.FOUNDATIONAL, "Foundational");
        } else if (item.getItemId() == R.id.action_digital) {
            //start activity
            startCategoryActivity(Category.DIGITAL, "Digital");
        } else if (item.getItemId() == R.id.action_specialized) {
            //start activity
            startCategoryActivity(Category.SPECIALIZED, "Specialized");
        } else if (item.getItemId() == R.id.action_cartoon_and_comic) {
            //start activity
            startCategoryActivity(Category.CARTOON_AND_COMIC, "Cartoon and Comic");
        }

        return super.onOptionsItemSelected(item);
    }

    private void startCategoryActivity(String categoryId, String header) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", categoryId);
        intent.putExtra("header", header);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}