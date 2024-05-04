package com.lina.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Linking XML elements with Java
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_btn);

        // Setting click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login logic here
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String studentRole = "student";
        String teacherRole = "teacher";

        // Authenticate user login
        boolean isValidStudent = databaseHelper.authenticateUser(email, password, studentRole);
        boolean isValidTeacher = databaseHelper.authenticateUser(email, password, teacherRole);

        if (isValidStudent) {
            // Login successful as student
            Toast.makeText(this, "Login successful as Student", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, StudentHomepageActivity.class);
            startActivity(intent);
            finish(); // Close login activity
        } else if (isValidTeacher) {
            // Login successful as teacher
            Toast.makeText(this, "Login successful as Teacher", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, TeacherHomepageActivity.class);
            startActivity(intent);
            finish(); // Close login activity
        } else {
            // Login failed
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }


}
