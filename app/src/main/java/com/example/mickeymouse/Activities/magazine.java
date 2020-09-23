package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;
import com.example.mickeymouse.magazines.MagApril;
import com.example.mickeymouse.magazines.MagAug;
import com.example.mickeymouse.magazines.MagFeb;
import com.example.mickeymouse.magazines.MagJuly;
import com.example.mickeymouse.magazines.MagJune;
import com.example.mickeymouse.magazines.MagMarch;
import com.example.mickeymouse.magazines.MagNov;
import com.example.mickeymouse.magazines.MagOct;
import com.example.mickeymouse.magazines.Magmay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class magazine extends AppCompatActivity implements View.OnClickListener {
    Button viewbtn,backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        backbtn = (Button) findViewById(R.id.back);
        backbtn.setOnClickListener(this);
        viewbtn = (Button) findViewById(R.id.pdfs);
        viewbtn.setOnClickListener(this);
    }
    public void onClick (View v) {
        if (v.getId() == R.id.pdfs) {
            PopupMenu popup = new PopupMenu(magazine.this, viewbtn);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.feb) {
                        Intent intent = new Intent(magazine.this, MagFeb.class);
                        startActivity(intent);
                    } else if (id == R.id.march) {
                        Intent intent = new Intent(magazine.this, MagMarch.class);
                        startActivity(intent);
                    } else if (id == R.id.april) {
                        Intent intent = new Intent(magazine.this, MagApril.class);
                        startActivity(intent);
                    } else if (id == R.id.may) {
                        Intent intent = new Intent(magazine.this, Magmay.class);
                        startActivity(intent);
                    } else if (id == R.id.june) {
                        Intent intent = new Intent(magazine.this, MagJune.class);
                        startActivity(intent);
                    } else if (id == R.id.july) {
                        Intent intent = new Intent(magazine.this, MagJuly.class);
                        startActivity(intent);
                    } else if (id == R.id.aug) {
                        Intent intent = new Intent(magazine.this, MagAug.class);
                        startActivity(intent);
                    } else if (id == R.id.oct) {
                        Intent intent = new Intent(magazine.this, MagOct.class);
                        startActivity(intent);
                    } else if (id == R.id.nov) {
                        Intent intent = new Intent(magazine.this, MagNov.class);
                        startActivity(intent);
                    }
                    return true;
                }
            });
            popup.show();
        }
        else
            if (v.getId()==R.id.back){
                Intent intent = new Intent(magazine.this, mickeyworld.class);
                startActivity(intent);
            }
    }
}
