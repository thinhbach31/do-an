package com.example.thinhbachvan.soundcloud.screen.library;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.thinhbachvan.soundcloud.OnClickSongListener;
import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.repository.TrackRepository;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment implements LibraryContract.View, OnClickSongListener {

    private static final int REQUEST_CODE = 1;
    private LibraryContract.Presenter mPresenter;
    private LibraryAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        initRecycler(view);
        initPresenter();
        checkForPermission();
        return view;
    }

    private void checkForPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        } else {
            mPresenter.loadListSong();
        }
    }

    private void initPresenter() {
        TrackRepository repository = TrackRepository.getInstanceLocal(getContext());
        mPresenter = new LibraryPresenter(repository);
        mPresenter.setView(this);
    }

    private void initRecycler(View view) {
        RecyclerView.LayoutManager layoutManager;
        mRecyclerView = view.findViewById(R.id.recycler_library);
        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new LibraryAdapter(this, getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemSongClick(List<Track> tracks, int position) {

    }

    @Override
    public void showListTrack(List<Track> tracks) {
        mAdapter.setTracks(tracks);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNoTrack() {
        Toast.makeText(getContext(), R.string.error_no_track, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorLoadTrack() {
        Toast.makeText(getContext(), R.string.error_load_song, Toast.LENGTH_SHORT).show();
    }
}
