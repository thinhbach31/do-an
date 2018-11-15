package com.example.thinhbachvan.soundcloud.screen.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.screen.main.MainActivity;

import pl.droidsonroids.gif.GifImageView;

public class Splash extends AppCompatActivity implements SplashContract.View {

    private SplashContract.Presenter mPresenter;
    private static final int SPLASH_DISPLAY_LENGTH = 3000;
    private GifImageView mGifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter = new SplashPresenter(this);
        handler();
        mGifImageView = findViewById(R.id.gif_splash);
        mGifImageView.setImageResource(R.drawable.splashgif);
    }

    private void handler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.changeUI();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    @Override
    public void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
