package com.example.thinhbachvan.soundcloud.screen.genre.genre_detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinhbachvan.soundcloud.R;

public class GenreDetailFragment extends Fragment {

    public static final String BUNDLE_GENRE_TYPE = "GENRE_TYPE";


    public static GenreDetailFragment newInstance(String genre){
        GenreDetailFragment genreDetailFragment = new GenreDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_GENRE_TYPE, genre);
        genreDetailFragment.setArguments(bundle);
        return genreDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genre_detail, container, false);
        return view;
    }
}
