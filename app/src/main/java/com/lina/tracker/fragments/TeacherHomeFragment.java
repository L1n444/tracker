package com.lina.tracker.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.lina.tracker.R;

public class TeacherHomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher_home, container, false);

        // RelativeLayout 1 click listener
        RelativeLayout createQrLayout = view.findViewById(R.id.create_btn);
        createQrLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to TeacherCreateFragment
                TeacherCreateFragment fragment = new TeacherCreateFragment();
                replaceFragment(fragment);
            }
        });

        // RelativeLayout 2 click listener
        RelativeLayout viewReportLayout = view.findViewById(R.id.view_btn);
        viewReportLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to TeacherViewFragment
                TeacherViewFragment fragment = new TeacherViewFragment();
                replaceFragment(fragment);
            }
        });

        return view;
    }

    // Method to replace fragments
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutTeacher, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
