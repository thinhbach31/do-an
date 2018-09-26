package com.example.thinhbachvan.soundcloud.screen.splash;

import com.example.thinhbachvan.soundcloud.Base;

public interface SplashContract {
    interface View extends Base.BaseView<Presenter> {
        void goToMain();
    }
    interface Presenter extends Base.BasePresenter{
        void changeUI();
    }
}
