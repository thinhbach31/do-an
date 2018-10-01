package com.example.thinhbachvan.soundcloud.data.source.local;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Genre;
import com.example.thinhbachvan.soundcloud.data.source.GenreDataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenreLocalDataSource implements GenreDataSource {

    @Override
    public List<Genre> getGenre() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(GenreEntity.ALL_AUDIO,
                R.drawable.all_music, R.string.title_all_audio));
        genres.add(new Genre(GenreEntity.ALTERNATIVE,
                R.drawable.rock, R.string.title_alternative));
        genres.add(new Genre(GenreEntity.AMBIENT,
                R.drawable.ambient, R.string.title_ambient));
        genres.add(new Genre(GenreEntity.CLASSICAL,
                R.drawable.classic, R.string.title_classic));
        genres.add(new Genre(GenreEntity.COUNTRY,
                R.drawable.country, R.string.title_country));

        return genres;
    }

    public @interface GenreEntity {

        String ALL_AUDIO = "all-audio";
        String ALTERNATIVE = "alternative-rock";
        String AMBIENT = "ambient";
        String CLASSICAL = "classical";
        String COUNTRY = "country";
    }
}
