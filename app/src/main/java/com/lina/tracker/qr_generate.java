package com.lina.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qr_generate extends AppCompatActivity {

    EditText qr_input;
    Button qr_btn;
    ImageView qr_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generate);

        qr_input = findViewById(R.id.qr_input);
        qr_btn = findViewById(R.id.qr_btn);
        qr_display = findViewById(R.id.qr_display);

        qr_btn.setOnClickListener(v->{
            generateQR();
        });
    }
    private void generateQR() {
        String text = qr_input.getText().toString().trim();
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE,400,400);

            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            qr_display.setImageBitmap(bitmap);




        } catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}