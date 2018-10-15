package com.example.thinhbachvan.soundcloud.screen.genre.genre_detail;

import com.example.thinhbachvan.soundcloud.Base;
import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.List;

public interface GenreDetailContract {
    interface View extends Base.BaseView<Presenter>{
        void showNoTrack();

        void showTrack(List<Track> tracks);

        void loadTrackError(String message);

        void showLoadingIndicator();

        void hideLoadingIndicator();
    }

    interface Presenter extends Base.BasePresenter{
        void loadTrack(String genre, int limit, int offset);
    }
}
