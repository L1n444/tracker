package com.lina.tracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lina.tracker.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TeacherViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherViewFragment newInstance(String param1, String param2) {
        TeacherViewFragment fragment = new TeacherViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_view, container, false);

//        //navbar thing
//
//
//        BottomNavigationView bottomNavigationView = bottomNavigationView.findViewById(R.id.nav_teach);
//
//        // Set a listener to handle item clicks
//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.T_home:
//                    // Handle home item click
//                    return true;
//                case R.id.T_qr:
//                    // Handle QR item click
//                    return true;
//                case R.id.T_rep:
//                    // Handle report item click
//                    return true;
//                case R.id.T_pro:
//                    // Handle profile item click
//                    return true;
//                default:
//                    return false;
//            }
//        });
//
//
////end of nav thing


    }
}