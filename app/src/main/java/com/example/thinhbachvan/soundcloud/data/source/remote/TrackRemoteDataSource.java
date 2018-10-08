package com.example.thinhbachvan.soundcloud.data.source.remote;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;
import com.example.thinhbachvan.soundcloud.utils.StringUtils;

public class TrackRemoteDataSource implements TrackDataSource.RemoteDataSource {
    private static TrackRemoteDataSource sRemoteDataSource;

    public static TrackRemoteDataSource getInstance(){
        if (sRemoteDataSource == null){
            sRemoteDataSource = new TrackRemoteDataSource();
        }
        return sRemoteDataSource;
    }
    @Override
    public void getTrackRemote(String genre, int limit, int offset,
                               OnFetchDataListener<Track> listener) {
        new FetchGenreFromURL(listener)
                .execute(StringUtils.convertUrlFetchMusicGenre(genre, limit, offset));
    }

    @Override
    public void searchTrackRemote(String trackName, int limit, int offset,
                                  OnFetchDataListener<Track> listener) {

    }
}
