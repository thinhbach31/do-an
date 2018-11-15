package com.example.thinhbachvan.soundcloud.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    private static final int VISIBLE_THRESHOLE = 5;
    private LinearLayoutManager mLayoutManager;
    private boolean mIsLoading = true;
    private int mPreviousTotal = 0;

    public EndlessScrollListener(LinearLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = mLayoutManager.getChildCount();
        int totalItemCount = mLayoutManager.getItemCount();
        int firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

        if (mIsLoading && totalItemCount > mPreviousTotal){
            mIsLoading = false;
            mPreviousTotal = totalItemCount;
        }

        if (!mIsLoading && (totalItemCount - visibleItemCount) <=
                (firstVisibleItem + VISIBLE_THRESHOLE)){
            onLoadMore(totalItemCount);
            mIsLoading = true;
        }
    }

    protected abstract void onLoadMore(int offset);
}
