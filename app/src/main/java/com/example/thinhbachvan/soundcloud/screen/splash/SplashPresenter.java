package com.example.thinhbachvan.soundcloud.screen.splash;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    public SplashPresenter(SplashContract.View view) {
        mView = view;
    }

    @Override
    public void changeUI() {
        mView.goToMain();
    }

    @Override
    public void start() {
        mView.setPresenter(this);
    }
}
