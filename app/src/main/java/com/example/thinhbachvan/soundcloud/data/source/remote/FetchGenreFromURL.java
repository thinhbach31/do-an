package com.example.thinhbachvan.soundcloud.data.source.remote;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;

public class FetchGenreFromURL extends BaseFetchTrackFromURL {
    public FetchGenreFromURL(TrackDataSource.OnFetchDataListener<Track> listener) {
        super(listener);
    }

}
