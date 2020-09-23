package com.example.mickeymouse.magazines;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class MagJuly extends AppCompatActivity {
    PDFView pdfobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_july);
        pdfobj = (PDFView) findViewById(R.id.pdfjuly);
        pdfobj.fromAsset("july.pdf").load();
    }
}
