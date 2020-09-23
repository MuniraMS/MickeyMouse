package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import com.example.mickeymouse.R;


public class MainActivity extends AppCompatActivity {
    private static int splash=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (MainActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
            }
        },splash);

    }
}
