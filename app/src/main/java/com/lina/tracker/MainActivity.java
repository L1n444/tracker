package com.lina.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View; // Import View
import android.widget.ImageView;

import com.lina.tracker.fragments.TeacherHomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, TeacherHomepageActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
