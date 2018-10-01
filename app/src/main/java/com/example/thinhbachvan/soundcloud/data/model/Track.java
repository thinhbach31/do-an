package com.example.thinhbachvan.soundcloud.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Track implements Parcelable {
    private int mID;
    private Artist mArtist;
    private String mTitle;
    private String mArtworkURL;
    private String mDownloadURL;
    private String mSongURI;
    private int mLikeCount;
    private int mPlayCount;
    private int mDuration;
    private boolean mDownloadable;

    protected Track(Parcel in) {
        mID = in.readInt();
        mTitle = in.readString();
        mArtworkURL = in.readString();
        mDownloadURL = in.readString();
        mSongURI = in.readString();
        mLikeCount = in.readInt();
        mPlayCount = in.readInt();
        mDuration = in.readInt();
        mDownloadable = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeString(mTitle);
        dest.writeString(mArtworkURL);
        dest.writeString(mDownloadURL);
        dest.writeString(mSongURI);
        dest.writeInt(mLikeCount);
        dest.writeInt(mPlayCount);
        dest.writeInt(mDuration);
        dest.writeByte((byte) (mDownloadable ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public Track(int id, Artist artist, String title,
                 String artworkURL, String songURI, int duration) {
        mID = id;
        mArtist = artist;
        mTitle = title;
        mArtworkURL = artworkURL;
        mSongURI = songURI;
        mDuration = duration;
    }

    public Track(int ID, Artist artist, String title, String artworkURL, String downloadURL,
                 String songURI, int likeCount, int playCount, int duration) {
        mID = ID;
        mArtist = artist;
        mTitle = title;
        mArtworkURL = artworkURL;
        mDownloadURL = downloadURL;
        mSongURI = songURI;
        mLikeCount = likeCount;
        mPlayCount = playCount;
        mDuration = duration;
    }

    public Track() {
        mArtworkURL = "";
        mDownloadURL = "";
        mDuration = 0;
        mID = 0;
        mArtist = new Artist();
        mLikeCount = 0;
        mTitle = "";
        mSongURI = "";

    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public Artist getArtist() {
        return mArtist;
    }

    public void setArtist(Artist artist) {
        mArtist = artist;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getArtworkURL() {
        return mArtworkURL;
    }

    public void setArtworkURL(String artworkURL) {
        mArtworkURL = artworkURL;
    }

    public String getDownloadURL() {
        return mDownloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        mDownloadURL = downloadURL;
    }

    public String getSongURI() {
        return mSongURI;
    }

    public void setSongURI(String songURI) {
        mSongURI = songURI;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(int likeCount) {
        mLikeCount = likeCount;
    }

    public int getPlayCount() {
        return mPlayCount;
    }

    public void setPlayCount(int playCount) {
        mPlayCount = playCount;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public boolean isDownloadable() {
        return mDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mDownloadable = downloadable;
    }

    public static class TrackEntity {
        public static final String COLLECTION = "collection";
        public static final String ARTWORK_URL = "artwork_url";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String DURATION = "duration";
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String SONGURI = "uri";
        public static final String USER = "user";
        public static final String TRACK = "track";
        public static final String USERNAME = "username";
        public static final String LIKES_COUNT = "likes_count";
        public static final String PLAY_COUNT = "playback_count";
        public static final String AVATAR_URL = "avatar_url";
        public static final String LARGE_IMAGE_SIZE = "large";
        public static final String BETTER_IMAGE_SIZE = "original";
        public static final String DOWNLOADABLE = "downloadable";
    }
}
