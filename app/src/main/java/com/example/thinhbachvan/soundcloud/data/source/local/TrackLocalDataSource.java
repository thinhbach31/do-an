package com.example.thinhbachvan.soundcloud.data.source.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;
import com.example.thinhbachvan.soundcloud.data.source.local.config.TrackDataHelper;

import java.util.ArrayList;

public class TrackLocalDataSource implements TrackDataSource.LocalDataSource {

    private static final String SORT_ORDER = " ASC";

    private static TrackLocalDataSource sLocalDataSource;
    private Context mContext;
    private TrackDataHelper mDataHelper;

    public static TrackLocalDataSource getInstance(Context context){
        if (sLocalDataSource == null){
            sLocalDataSource = new TrackLocalDataSource(context);
        }
        return sLocalDataSource;
    }

    public TrackLocalDataSource(Context context) {
        mContext = context;
        mDataHelper = TrackDataHelper.getInstance(context);
    }

    @Override
    public void getTrackLocal(OnFetchDataListener<Track> listener) {
        ArrayList<Track> tracks = new ArrayList<>();
        String[] projections = new String[]{
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media._ID,
        };

        ContentResolver contentResolver = mContext.getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, projections, null, null,
                MediaStore.Audio.Media.TITLE + SORT_ORDER);

        if (cursor == null){
            listener.onFetchFailure(mContext.getString(R.string.messenger_load_track_fail));
            return;
        }

        if (!cursor.moveToFirst()){
            listener.onFetchDataSuccess(tracks);
            return;
        }

        int titleColumn = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int pathColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
        int durationColumn = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int idColumn = cursor.getColumnIndex(MediaStore.Audio.Media._ID);
        int artist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

        do {
            Track track = new Track();
            track.setTitle(cursor.getString(titleColumn));
            track.setSongURI(cursor.getString(pathColumn));
            track.setDuration(cursor.getInt(durationColumn));
            track.setID(cursor.getInt(idColumn));
            track.setArtist(cursor.getString(artist));
            tracks.add(track);
        } while (cursor.moveToNext());

        listener.onFetchDataSuccess(tracks);
    }
}
