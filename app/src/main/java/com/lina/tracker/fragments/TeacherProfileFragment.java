package com.lina.tracker.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lina.tracker.LoginActivity;
import com.lina.tracker.R;

public class TeacherProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher_profile, container, false);

        // Logout button
        Button logoutButton = view.findViewById(R.id.logoutButtonT);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout actions here
                // For example, clear session or user data
                // Then navigate to the login page
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish(); // Close the current activity
            }
        });

        return view;
    }
}
