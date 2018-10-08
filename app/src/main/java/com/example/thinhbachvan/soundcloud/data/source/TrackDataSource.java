package com.example.thinhbachvan.soundcloud.data.source;

import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.List;

public interface TrackDataSource {

    interface LocalDataSource extends TrackDataSource{
        void getTrackLocal(OnFetchDataListener<Track> listener);
    }

    interface RemoteDataSource extends TrackDataSource{
        void getTrackRemote(String genre, int limit, int offset,
                            OnFetchDataListener<Track> listener);
        void searchTrackRemote(String trackName, int limit, int offset,
                               OnFetchDataListener<Track> listener);
    }

    interface OnFetchDataListener<T>{
        void onFetchDataSuccess(List<T> data);

        void onFetchFailure(String messenger);
    }
}
