package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mickeymouse.R;
import com.example.mickeymouse.Database.DatabaseHelper;

public class Signup extends AppCompatActivity implements View.OnClickListener  {
    EditText nameedt, emailedit, passwordedt;
    Button signup,previous;
    TextView alreadyuser;
    DatabaseHelper dbhelper;
    String name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbhelper = DatabaseHelper.getInstance(this);
        nameedt = (EditText) findViewById(R.id.name);
        emailedit = (EditText) findViewById(R.id.email);
        passwordedt = (EditText) findViewById(R.id.password);
        alreadyuser = (TextView) findViewById(R.id.textView3);
        alreadyuser.setOnClickListener(this);
        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);
        previous = (Button) findViewById(R.id.previous);
        previous.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId()==R.id.textView3){
            Intent intent = new Intent (Signup.this,login.class);
            startActivity(intent);
        }
        else
            if (v.getId()==R.id.signup){
                name = nameedt.getText().toString();
                email = emailedit.getText().toString();
                password = passwordedt.getText().toString();
                boolean isvalid = dbhelper.validmail(email);
                if (isvalid) {
                    dbhelper.signup(name,email,password);
                    Toast.makeText(this,"you have signed up successfully.",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (this,login.class);
                    startActivity(intent);
                }
                else
                    if (!isvalid){
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                        builder1.setMessage("You have entered invalid email.");
                        builder1.setTitle("Warning");
                        builder1.setCancelable(true);
                        builder1.setPositiveButton(
                                "Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        nameedt.setText("");
                                        emailedit.setText("");
                                        passwordedt.setText("");
                                    }
                                });
                        AlertDialog alert11 = builder1.create();
                        alert11.show();

                    }
            }
            else
                if (v.getId()==R.id.previous){
                    finish();
                }
    }

}
