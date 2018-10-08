package com.example.thinhbachvan.soundcloud.data.repository;

import android.content.Context;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;
import com.example.thinhbachvan.soundcloud.data.source.local.TrackLocalDataSource;
import com.example.thinhbachvan.soundcloud.data.source.remote.TrackRemoteDataSource;

public class TrackRepository implements TrackDataSource.LocalDataSource,
        TrackDataSource.RemoteDataSource {

    private static TrackRepository sTrackRepository;
    private TrackDataSource.LocalDataSource mLocalDataSource;
    private TrackDataSource.RemoteDataSource mRemoteDataSource;

    public static TrackRepository getInstanceLocal(Context context) {
        if (sTrackRepository == null) {
            sTrackRepository = new TrackRepository(
                    TrackLocalDataSource.getInstance(context));
        }
        return sTrackRepository;
    }

    public static TrackRepository getInstanceRemote(){
        if (sTrackRepository == null){
            sTrackRepository = new TrackRepository(TrackRemoteDataSource.getInstance());
        }
        return sTrackRepository;
    }

    public TrackRepository(LocalDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public TrackRepository(RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getTrackLocal(OnFetchDataListener<Track> listener) {
        if (mLocalDataSource == null) return;
        mLocalDataSource.getTrackLocal(listener);
    }

    @Override
    public void getTrackRemote(String genre, int limit, int offset,
                               OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource == null) return;
        mRemoteDataSource.getTrackRemote(genre, limit, offset, listener);
    }

    @Override
    public void searchTrackRemote(String trackName, int limit, int offset,
                                  OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource == null) return;
        mRemoteDataSource.searchTrackRemote(trackName, limit, offset, listener);
    }
}
