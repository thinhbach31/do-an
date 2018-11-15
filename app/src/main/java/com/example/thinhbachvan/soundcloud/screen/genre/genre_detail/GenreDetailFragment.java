package com.example.thinhbachvan.soundcloud.screen.genre.genre_detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.thinhbachvan.soundcloud.OnClickSongListener;
import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.TrackListener;
import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.repository.TrackRepository;
import com.example.thinhbachvan.soundcloud.utils.ConstantNetwork;
import com.example.thinhbachvan.soundcloud.utils.EndlessScrollListener;

import java.util.List;

public class GenreDetailFragment extends Fragment implements GenreDetailContract.View,
        OnClickSongListener {

    public static final String BUNDLE_GENRE_TYPE = "GENRE_TYPE";
    private GenreDetailContract.Presenter mPresenter;
    private GenreDetailAdapter mAdapter;
    private TrackListener mTrackListener;
    private ProgressBar mProgressLoading;
    private String mGenre;

    public static GenreDetailFragment newInstance(String genre) {
        GenreDetailFragment genreDetailFragment = new GenreDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_GENRE_TYPE, genre);
        genreDetailFragment.setArguments(bundle);
        return genreDetailFragment;
    }

    public GenreDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_genre_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new GenreDetailPresenter(this, TrackRepository.getInstanceRemote());
        mGenre = getArguments().getString(BUNDLE_GENRE_TYPE);
        setupComponent(view);
        mPresenter.loadTrack(mGenre, ConstantNetwork.LIMIT_DEFAULT, ConstantNetwork.OFFSET_DEFAULT);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrackListener) {
            mTrackListener = (TrackListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mTrackListener = null;
    }

    @Override
    public void onItemSongClick(List<Track> tracks, int position) {

    }

    @Override
    public void showNoTrack() {
        Toast.makeText(getContext(), R.string.error_no_track, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTrack(List<Track> tracks) {
        mAdapter.updateListTrack(tracks);
    }

    @Override
    public void loadTrackError(String message) {

    }

    @Override
    public void showLoadingIndicator() {
        mProgressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressLoading.setVisibility(View.GONE);
    }

    public void setupComponent(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new GenreDetailAdapter(mTrackListener, this, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_itemGenreDetail);
        mProgressLoading = view.findViewById(R.id.progress_loading);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)
        );
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new EndlessScrollListener(linearLayoutManager) {
            @Override
            protected void onLoadMore(int offset) {
                mPresenter.loadTrack(mGenre, ConstantNetwork.LIMIT_DEFAULT, offset);
            }
        });
    }

    @Override
    public void setPresenter(GenreDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new GenreDetailPresenter(this, TrackRepository.getInstanceRemote());
        mGenre = getArguments().getString(BUNDLE_GENRE_TYPE);
        setupComponent(view);
        mPresenter.loadTrack(mGenre, ConstantNetwork.LIMIT_DEFAULT, ConstantNetwork.OFFSET_DEFAULT);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrackListener) {
            mTrackListener = (TrackListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mTrackListener = null;
    }

    @Override
    public void onItemSongClick(List<Track> tracks, int position) {

    }

    @Override
    public void showNoTrack() {
        Toast.makeText(getContext(), R.string.error_no_track, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTrack(List<Track> tracks) {
        mAdapter.updateListTrack(tracks);
    }

    @Override
    public void loadTrackError(String message) {

    }

    @Override
    public void showLoadingIndicator() {
        mProgressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        mProgressLoading.setVisibility(View.GONE);
    }

    public void setupComponent(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new GenreDetailAdapter(mTrackListener, this, getContext());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_itemGenreDetail);
        mProgressLoading = view.findViewById(R.id.progress_loading);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)
        );
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnScrollListener(new EndlessScrollListener(linearLayoutManager) {
            @Override
            protected void onLoadMore(int offset) {
                mPresenter.loadTrack(mGenre, ConstantNetwork.LIMIT_DEFAULT, offset);
            }
        });
    }

    @Override
    public void setPresenter(GenreDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
