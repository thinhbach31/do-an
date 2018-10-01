package com.example.thinhbachvan.soundcloud.screen.genre;

import com.example.thinhbachvan.soundcloud.data.model.Genre;

import java.util.List;

public interface GenreContract {
    interface Presenter{
        void loadGenre();
    }

    interface View{
        void showGenre(List<Genre> genres);
    }
}
