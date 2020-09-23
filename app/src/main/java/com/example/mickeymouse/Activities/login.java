package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mickeymouse.Database.DatabaseHelper;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText emailedt , passwordedt;
    Button btnlogin,btnprevious;
    TextView notuser;
    String email , password;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbhelper = DatabaseHelper.getInstance(this);
        emailedt = (EditText) findViewById(R.id.email);
        passwordedt = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.login);
        btnlogin.setOnClickListener(this);
        notuser = (TextView) findViewById(R.id.textView6);
        notuser.setOnClickListener(this);
        btnprevious = (Button) findViewById(R.id.previous);
        btnprevious.setOnClickListener(this);
    }
    public void onClick (View v) {
        if (v.getId()==R.id.textView6){
            Intent intent = new Intent (this,Signup.class);
            startActivity(intent);
        }
        else
            if (v.getId()==R.id.login){
                email =emailedt.getText().toString();
                password = passwordedt.getText().toString();
                boolean islogged = dbhelper.login(email,password);
                if (islogged){
                Toast.makeText(this,"logged in successfully.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (this,mickeyworld.class);
                startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    builder1.setCancelable(false);
                    builder1.setTitle("warning");
                    builder1.setMessage("You have entered invalid parameters. Press ok to try again or sign up to create an account.");
                    builder1.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            emailedt.setText("");
                            passwordedt.setText("");
                        }})
                            .setNegativeButton("sign up",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    gotosignup();
                                }
                            });
                    final AlertDialog alert = builder1.create();
                    alert.show();

                }
            }
            else
                if (v.getId()==R.id.previous){
                    finish();
                }
    }
    private void gotosignup(){
        Intent intent = new Intent (this,Signup.class);
        startActivity(intent);
    }
}
