package com.example.thinhbachvan.soundcloud.data.source.local;

import com.example.thinhbachvan.soundcloud.data.model.Genre;
import com.example.thinhbachvan.soundcloud.data.source.GenreDataSource;

import java.util.List;

public class GenreLocalDataSource implements GenreDataSource {


    @Override
    public List<Genre> getGenre() {
        return null;
    }

    public @interface GenreEntity {

        String ALL_MUSIC = "all-music";
        String ALL_AUDIO = "all-audio";
        String ALTERNATIVE = "alternativerock";
        String AMBIENT = "ambient";
        String CLASSICAL = "classical";
        String COUNTRY = "country";
    }
}
