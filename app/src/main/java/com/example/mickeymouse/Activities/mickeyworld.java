package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

public class mickeyworld extends AppCompatActivity implements View.OnClickListener{
    ImageButton charctersbtn,magazinebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mickeyworld);
        charctersbtn = (ImageButton)findViewById(R.id.charcters);
        charctersbtn.setOnClickListener(this);
        magazinebtn = (ImageButton) findViewById(R.id.mag);
        magazinebtn.setOnClickListener(this);
    }
    public void onClick (View v) {
        if (v.getId()==R.id.charcters){
            Intent intent = new Intent (this,characters.class);
            startActivity(intent);
        }
        else
            if (v.getId()==R.id.mag){
                Intent intent = new Intent (this,magazine.class);
                startActivity(intent);
            }
    }
}
