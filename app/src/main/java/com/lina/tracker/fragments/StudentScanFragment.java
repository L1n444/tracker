package com.lina.tracker.fragments;

import static com.lina.tracker.R.id.scanBtn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lina.tracker.R;

public class StudentScanFragment extends Fragment implements View.OnClickListener {

    private Button scanBtn;
    private TextView messageText, messageFormat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_scan, container, false);

        // Initialize views
        scanBtn = view.findViewById(R.id.scanBtn);
        messageText = view.findViewById(R.id.textContent);
        messageFormat = view.findViewById(R.id.textFormat);

        // Set click listener
        scanBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        // Create an object of IntentIntegrator class
        // which is the class of QR library
        IntentIntegrator intentIntegrator = IntentIntegrator.forSupportFragment(this);
        intentIntegrator.setPrompt("Scan a barcode or QR Code");
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        // If the intentResult is null then
        // toast a message as "cancelled"
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(requireContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            } else {
                // If the intentResult is not null, set
                // the content and format of the scan message
                messageText.setText(intentResult.getContents());
                messageFormat.setText(intentResult.getFormatName());
            }
        }
    }
}
