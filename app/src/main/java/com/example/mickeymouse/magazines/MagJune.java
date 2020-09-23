package com.example.mickeymouse.magazines;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class MagJune extends AppCompatActivity {
    PDFView pdfobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_june);
        pdfobj = (PDFView) findViewById(R.id.pdfjune);
        pdfobj.fromAsset("june.pdf").load();
    }
}
