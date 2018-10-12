package com.example.thinhbachvan.soundcloud.screen.playing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.screen.main.MainActivity;

public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //startActivity(new Intent(PlayingActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.slide_down, R.anim.slide_down);
    }
}
