package com.lina.tracker;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.lina.tracker.fragments.TeacherCreateFragment;
import com.lina.tracker.fragments.TeacherHomeFragment;
import com.lina.tracker.fragments.TeacherProfileFragment;
import com.lina.tracker.fragments.TeacherViewFragment;


public class TeacherHomepageActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TeacherHomeFragment teacherHomeFragment = new  TeacherHomeFragment();
    TeacherCreateFragment teacherCreateFragment = new TeacherCreateFragment();
    TeacherViewFragment teacherViewFragment = new TeacherViewFragment();
    TeacherProfileFragment teacherProfileFragment = new TeacherProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, teacherHomeFragment).commit();

        // Handle navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if (item.getItemId() == R.id.home) {
                    fragment = teacherHomeFragment;
                } else if (item.getItemId() == R.id.scan) {
                    fragment = teacherCreateFragment;
                } else if (item.getItemId() == R.id.history) {
                    fragment = teacherViewFragment;
                } else if (item.getItemId() == R.id.profile) {
                    fragment = teacherProfileFragment;
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                }
                return false;
            }
        });
    }
}
