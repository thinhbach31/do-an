package com.example.thinhbachvan.soundcloud.utils;

import android.annotation.SuppressLint;

import com.example.thinhbachvan.soundcloud.BuildConfig;

public class StringUtils {

    @SuppressLint("DefaultLocale")
    public static String convertUrlFetchMusicGenre(String genre, int limit, int offset) {
        return String.format("%s%s%s%s=%s&%s=%d&%s=%d", ConstantNetwork.BASE_URL,
                ConstantNetwork.PARA_MUSIC_GENRE, genre, ConstantNetwork.CLIENT_ID,
                /*, ConstantNetwork.LIMIT*/"sdf", limit,
                ConstantNetwork.PARA_OFFSET, offset);
    }

    public static String getUrlStreamTrack(String uriTrack) {
        return String.format("%s/%s?%s=%s", uriTrack, ConstantNetwork.PARA_STREAM,
                ConstantNetwork.CLIENT_ID, "sdf"/* ,BuildConfig.API_KEY*/);
    }

    public static String convertURlDownloadTrack(String url) {
        return String.format("%s?%s=%s", url, ConstantNetwork.CLIENT_ID,"sdf"
                /*BuildConfig.API_KEY*/);
    }

    public static String convertUrlSearchTrack(String trackName, int limit, int offset) {
        return String.format("%s%s%s&%s=%d&%s=%d&%s=%s", ConstantNetwork.BASE_URL,
                ConstantNetwork.PARA_SEARCH_TRACK, trackName, ConstantNetwork.LIMIT, limit,
                ConstantNetwork.PARA_OFFSET, offset, ConstantNetwork.CLIENT_ID, "sdf"
                /*BuildConfig.API_KEY*/);
    }
}
