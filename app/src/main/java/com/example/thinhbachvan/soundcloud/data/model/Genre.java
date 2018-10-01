package com.example.thinhbachvan.soundcloud.data.model;

public class Genre {

    private String mApiName;
    private int mImageResource;
    private int mTitleResource;

    public Genre(String apiName, int imageResource, int titleResource) {

        mApiName = apiName;
        mImageResource = imageResource;
        mTitleResource = titleResource;
    }

    public String getApiName() {
        return mApiName;
    }

    public void setApiName(String apiName) {
        mApiName = apiName;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int imageResource) {
        mImageResource = imageResource;
    }

    public int getTitleResource() {
        return mTitleResource;
    }

    public void setTitleResource(int titleResource) {
        mTitleResource = titleResource;
    }
}
