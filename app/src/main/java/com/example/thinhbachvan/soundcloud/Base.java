package com.example.thinhbachvan.soundcloud;

public interface Base {
    interface BaseView<T>{
        void setPresenter(T presenter);
    }
    interface BasePresenter{
        void start();
    }
}
