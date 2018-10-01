package com.example.thinhbachvan.soundcloud.screen.genre;

import com.example.thinhbachvan.soundcloud.data.repository.GenreRepository;

public class GenrePresenter implements GenreContract.Presenter {
    private GenreContract.View mView;
    private GenreRepository mGenreRepository;

    public GenrePresenter(GenreContract.View view, GenreRepository genreRepository) {
        mView = view;
        mGenreRepository = genreRepository;
    }

    @Override
    public void loadGenre() {
        mView.showGenre(mGenreRepository.getGenre());
    }
}
