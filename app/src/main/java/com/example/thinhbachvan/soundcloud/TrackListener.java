package com.example.thinhbachvan.soundcloud;

import com.example.thinhbachvan.soundcloud.data.model.Track;

public interface TrackListener {
    void onDownloadTrack(Track track);

    void onLikeTrack(Track track);
}
