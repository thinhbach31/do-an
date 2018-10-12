package com.example.thinhbachvan.soundcloud.screen.library;

import com.example.thinhbachvan.soundcloud.data.repository.TrackRepository;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;

import java.util.List;

public class LibraryPresenter implements LibraryContract.Presenter,
        TrackDataSource.OnFetchDataListener {

    private LibraryContract.View mView;
    private TrackRepository mRepository;

    public LibraryPresenter(TrackRepository repository) {
        mRepository = repository;
    }

    @Override
    public void loadListSong() {
        mRepository.getTrackLocal(this);
    }

    @Override
    public void setView(LibraryContract.View view) {
        mView = view;
    }

    @Override
    public void onFetchDataSuccess(List data) {
        if (data == null || data.isEmpty()){
            mView.showNoTrack();
        } else {
            mView.showListTrack(data);
        }
    }

    @Override
    public void onFetchFailure(String messenger) {
        mView.showErrorLoadTrack();
    }
}
