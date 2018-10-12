package com.example.thinhbachvan.soundcloud.screen.library;

import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.List;

public interface LibraryContract {

    interface View{
        void showListTrack(List<Track> tracks);

        void showNoTrack();

        void showErrorLoadTrack();
    }

    interface Presenter{
        void loadListSong();

        void setView(LibraryContract.View view);
    }
}
