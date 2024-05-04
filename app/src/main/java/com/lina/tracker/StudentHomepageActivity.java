package com.lina.tracker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.lina.tracker.databinding.ActivityStudentHomepageBinding;
import com.lina.tracker.fragments.StudentHistoryFragment;
import com.lina.tracker.fragments.StudentHomeFragment;
import com.lina.tracker.fragments.StudentProfileFragment;
import com.lina.tracker.fragments.StudentScanFragment;

public class StudentHomepageActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    StudentHomeFragment studentHomeFragment = new StudentHomeFragment();
    StudentScanFragment studentScanFragment = new StudentScanFragment();
    StudentHistoryFragment studentHistoryFragment = new StudentHistoryFragment();
    StudentProfileFragment studentProfileFragment = new StudentProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, studentHomeFragment).commit();

        // Handle navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if (item.getItemId() == R.id.home) {
                    fragment = studentHomeFragment;
                } else if (item.getItemId() == R.id.scan) {
                    fragment = studentScanFragment;
                } else if (item.getItemId() == R.id.history) {
                    fragment = studentHistoryFragment;
                } else if (item.getItemId() == R.id.profile) {
                    fragment = studentProfileFragment;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
                }
                return false;
            }
        });
    }
}
