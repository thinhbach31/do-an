package com.example.thinhbachvan.soundcloud.data.repository;

import com.example.thinhbachvan.soundcloud.data.model.Genre;
import com.example.thinhbachvan.soundcloud.data.source.GenreDataSource;

import java.util.List;

public class GenreRepository {
    private static GenreRepository sInstance;
    private GenreDataSource mGenreDataSource;

    public GenreRepository(GenreDataSource genreDataSource) {
        mGenreDataSource = genreDataSource;
    }

    public static GenreRepository getInstance(GenreDataSource genreDataSource){
        if (sInstance == null){
            sInstance = new GenreRepository(genreDataSource);
        }
        return sInstance;
    }

    public List<Genre> getGenre(){
        return mGenreDataSource.getGenre();
    }
}
