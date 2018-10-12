package com.example.thinhbachvan.soundcloud.screen.main;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.screen.home.HomeFragment;
import com.example.thinhbachvan.soundcloud.screen.playing.PlayingActivity;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayoutContainFragment;
    private ConstraintLayout mLayoutPlaying;
    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragment();
        getSupportActionBar().setTitle(R.string.app_name2);

        mLayoutPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayingActivity.class));
                overridePendingTransition(R.anim.slide_up, R.anim.slide_up);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void addFragment() {
        if (mHomeFragment == null){
            mHomeFragment = new HomeFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(mFrameLayoutContainFragment.getId(), mHomeFragment).commit();
    }

    private void initView() {
        mFrameLayoutContainFragment = findViewById(R.id.main_frame_layout);
        mLayoutPlaying = findViewById(R.id.contrain_playing);
    }
}
