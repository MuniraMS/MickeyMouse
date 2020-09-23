package com.example.mickeymouse.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mickeymouse.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


public class characters extends AppCompatActivity implements View.OnClickListener  {
    MediaPlayer player;
    Button backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        backbtn = (Button) findViewById(R.id.button4);
        backbtn.setOnClickListener(this);
    }
    public void onClick (View v) {
        if (v.getId()==R.id.button4){
            Intent intent = new Intent (this,mickeyworld.class);
            startActivity(intent);
        }
    }
    public void play (View v) {
        if (player==null){
            player = MediaPlayer.create(this,R.raw.opening);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion (MediaPlayer mp){
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause (View v) {
        if (player!=null){
            player.pause();
        }
    }
    public void stop (View v) {
        stopPlayer();
    }
    private void stopPlayer () {
        if (player!=null){
            player.release();
            player=null;
            Toast.makeText(this,"song has been stopped.",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop () {
        super.onStop();
        stopPlayer();
    }
}
