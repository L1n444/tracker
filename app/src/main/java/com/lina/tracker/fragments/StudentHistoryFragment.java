package com.lina.tracker.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lina.tracker.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link StudentHistoryFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class StudentHistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_history, container, false);
    }
}