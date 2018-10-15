package com.example.thinhbachvan.soundcloud.screen.genre.genre_detail;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.repository.TrackRepository;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;

import java.util.ArrayList;
import java.util.List;

public class GenreDetailPresenter implements GenreDetailContract.Presenter, TrackDataSource.OnFetchDataListener {

    private GenreDetailContract.View mView;
    private TrackRepository mRepository;

    public GenreDetailPresenter(GenreDetailContract.View view, TrackRepository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void loadTrack(String genre, int limit, int offset) {
        mView.showLoadingIndicator();
        mRepository.getTrackRemote(genre, limit, offset, this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onFetchDataSuccess(List data) {
        mView.hideLoadingIndicator();
        if (data == null || data.isEmpty()){
            mView.showNoTrack();
            return;
        }
        mView.showTrack((ArrayList<Track>) data);
    }

    @Override
    public void onFetchFailure(String messenger) {
        mView.hideLoadingIndicator();
        mView.loadTrackError(messenger);
    }
}
