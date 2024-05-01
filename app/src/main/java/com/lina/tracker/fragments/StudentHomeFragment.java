package com.lina.tracker.fragments;

import android.content.Context; // Required for FragmentTransaction
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction; // For fragment transactions

import com.lina.tracker.R;

public class StudentHomeFragment extends Fragment {

    private Button viewnowButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_student__home_, container, false);

        // Find the button by its ID after the view is inflated
        viewnowButton = rootView.findViewById(R.id.viewnow_button);

        // Set the click listener for the button
        viewnowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new instance of StudentHistoryFragment (assuming default constructor)
                StudentHistoryFragment fragment = new StudentHistoryFragment();

                // Get the FragmentManager from the Activity (assuming StudentHomeFragment is within an Activity)
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace the current container with the new fragment
                transaction.replace(container.getId(), fragment).addToBackStack(null).commit();
            }
        });

        return rootView;
    }
}
