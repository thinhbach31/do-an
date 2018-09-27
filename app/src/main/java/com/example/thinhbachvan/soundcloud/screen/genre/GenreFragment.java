package com.example.thinhbachvan.soundcloud.screen.genre;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Genre;

import java.util.List;

public class GenreFragment extends Fragment implements GenreContract.View {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genre, container, false);
        return view;
    }

    @Override
    public void showGenre(List<Genre> genres) {

    }
}
