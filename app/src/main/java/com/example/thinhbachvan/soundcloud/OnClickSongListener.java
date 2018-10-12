package com.example.thinhbachvan.soundcloud;

import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.List;

public interface OnClickSongListener {
    void onItemSongClick(List<Track> tracks, int position);
}
