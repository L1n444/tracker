package com.lina.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lina.tracker.fragments.StudentHomeFragment;
import com.lina.tracker.fragments.TeacherHomeFragment;

public class LoginActivity extends AppCompatActivity {

    private EditText idEditText, passwordEditText;
    private Button loginButton;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);

        // Linking XML elements with Java
        idEditText = findViewById(R.id.id);
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
        String id = idEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String student = "student";
        String teacher = "teacher";
        // Perform validation checks...

        // Authenticate user login
        boolean isValidStudent = databaseHelper.authenticateUser(id, password, student);
        boolean isValidTeacher = databaseHelper.authenticateUser(id, password, teacher);
        if (isValidStudent) {
            // Login successful
            Toast.makeText(this, "Login successful as Student", Toast.LENGTH_SHORT).show();
            // Optionally, navigate to another activity
            // For example: startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

            Intent toUser = new Intent(LoginActivity.this, StudentHomeFragment.class);
            startActivity(toUser);
        } else {

            if (isValidTeacher) {
                // Login successful
                Toast.makeText(this, "Login successful as Teacher", Toast.LENGTH_SHORT).show();
                // Optionally, navigate to another activity
                // For example: startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

                Intent toAdmin = new Intent(LoginActivity.this, TeacherHomeFragment.class);
                startActivity(toAdmin);
            } else {

                // Login failed
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
