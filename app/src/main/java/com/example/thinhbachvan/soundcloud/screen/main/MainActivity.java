package com.example.thinhbachvan.soundcloud.screen.main;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.screen.home.HomeFragment;

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
