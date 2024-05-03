package com.lina.tracker.fragments;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.lina.tracker.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
public class TeacherHomeFragment extends Fragment {
    private Button createbutton;
    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_teacher_home, container, false);

        // Find the button by its ID after the view is inflated
        createbutton = rootView.findViewById(R.id.create_btn);

        // Set the click listener for the button
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new instance of StudentHistoryFragment (assuming default constructor)
                TeacherCreateFragment fragment = new TeacherCreateFragment();

                // Get the FragmentManager from the Activity (assuming StudentHomeFragment is within an Activity)
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace the current container with the new fragment
                //transaction.replace(container.getId(), fragment).addToBackStack(null).commit();
                // Replace the current container with the new fragment
                // Assuming you're in a Fragment
               // FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
               // transaction.replace(R.id.create_btn, fragment);
                //transaction.addToBackStack(null);
               // transaction.commit();
// Replace the current container with the new fragment
                transaction.replace(R.id.fragment_container, fragment);

            }
        });

        return rootView;
    }


}
