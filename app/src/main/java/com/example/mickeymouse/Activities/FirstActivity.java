package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.mickeymouse.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener  {
    ImageButton signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        signup = (ImageButton) findViewById(R.id.signup);
        signup.setOnClickListener(this);
        login = (ImageButton) findViewById(R.id.login);
        login.setOnClickListener(this);

    }
    @Override
    public void onClick (View v) {
        if (v.getId()==R.id.signup){
           Intent intent = new Intent (FirstActivity.this,Signup.class);
           startActivity(intent);
        }
        else
            if (v.getId()==R.id.login){
                Intent intent = new Intent (this,login.class);
                startActivity(intent);
            }
    }
}
