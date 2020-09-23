package com.example.mickeymouse.magazines;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;
import com.github.barteksc.pdfviewer.PDFView;
import android.os.Bundle;

public class MagMarch extends AppCompatActivity {
    PDFView pdfobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag_march);
        pdfobj = (PDFView) findViewById(R.id.pdfmarch);
        pdfobj.fromAsset("march.pdf").load();
    }
}
