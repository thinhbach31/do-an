package com.example.thinhbachvan.soundcloud.data.source.local.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.utils.Constain;

public class TrackDataHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "track";
    private static TrackDataHelper sTrackDataHelper;

    private static final String SQL_CREATE_TRACK_ENTRIES = "CREATE TABLE "
            + TABLE_NAME + " ("
            + Track.TrackEntity.ID + " INTEGER NOT NULL, "
            + Track.TrackEntity.TITLE + " TEXT, "
            + Track.TrackEntity.SONGURI + " TEXT, "
            + Track.TrackEntity.USERNAME + " TEXT, "
            + Track.TrackEntity.DURATION + " INTEGER, "
            + "PRIMARY KEY( "
            + Track.TrackEntity.ID + " ));";
    public TrackDataHelper(Context context) {
        super(context, Constain.DATABASE_NAME, null, Constain.DATABASE_VERSION);
    }

    public static TrackDataHelper getInstance(Context context){
        if (sTrackDataHelper == null){
            sTrackDataHelper = new TrackDataHelper(context);
        }
        return sTrackDataHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TRACK_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
