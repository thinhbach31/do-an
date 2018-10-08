package com.example.thinhbachvan.soundcloud.data.source.remote;

import android.os.AsyncTask;

import com.example.thinhbachvan.soundcloud.data.model.Track;
import com.example.thinhbachvan.soundcloud.data.source.TrackDataSource;
import com.example.thinhbachvan.soundcloud.utils.ConstantNetwork;
import com.example.thinhbachvan.soundcloud.utils.ConstantString;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BaseFetchTrackFromURL extends AsyncTask<String, Void, List<Track >> {

    private TrackDataSource.OnFetchDataListener<Track> mListener;
    private Exception mException;

    public BaseFetchTrackFromURL(TrackDataSource.OnFetchDataListener<Track> listener) {
        mListener = listener;
    }

    @Override
    protected List<Track> doInBackground(String... strings) {
        try {
            JSONObject jsonObject = new JSONObject(getJSONStringFromURL(strings[0]));
            return getTracksFromJSONObject(jsonObject);
        } catch (JSONException e) {
            mException = e;
        } catch (IOException e) {
            mException = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        if (mListener == null){
            return;
        }
        if (mException != null){
            mListener.onFetchFailure(mException.getMessage());
            return;
        }
        mListener.onFetchDataSuccess(tracks);
    }

    protected List<Track> getTracksFromJSONObject(JSONObject jsonObject) throws JSONException{
        ArrayList<Track> trackArrayList = new ArrayList<>();
        JSONArray jsonCollection = jsonObject.getJSONArray(Track.TrackEntity.COLLECTION);
        for (int i=0; i<jsonCollection.length(); i++){
            JSONObject jsonTrack = jsonCollection.getJSONObject(i);
            Track track = parseJSONObjectToTrackObject(jsonTrack);
            if (track != null){
                trackArrayList.add(track);
            }
        }
        return trackArrayList;
    }

    private String getJSONStringFromURL(String urlString) throws IOException{
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(ConstantNetwork.REQUEST_METHOD_GET);
        httpURLConnection.setReadTimeout(ConstantNetwork.READ_TIME_OUT);
        httpURLConnection.setConnectTimeout(ConstantNetwork.CONNECT_TIME_OUT);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            sb.append(line).append(ConstantString.BREAK_LINE);
        }
        br.close();
        httpURLConnection.disconnect();
        return sb.toString();
    }

    private String parseArtworkURLToBetter(String artworkURL){
        if (artworkURL != null){
            return artworkURL.replace(Track.TrackEntity.LARGE_IMAGE_SIZE,
                    Track.TrackEntity.BETTER_IMAGE_SIZE);
        }
        return null;
    }

    protected Track parseJSONObjectToTrackObject(JSONObject jsonObject){
        Track track = new Track();
        JSONObject trackJson = jsonObject.optJSONObject(Track.TrackEntity.TRACK);
        JSONObject jsonUser = trackJson.optJSONObject(Track.TrackEntity.USER);
        String artworkUrl = trackJson.optString(Track.TrackEntity.ARTWORK_URL);

        if (artworkUrl.equals(ConstantNetwork.NULL_RESULT)){
            artworkUrl = trackJson.optJSONObject(Track.TrackEntity.USER)
                    .optString(Track.TrackEntity.AVATAR_URL);
        }
        track.setArtworkURL(parseArtworkURLToBetter(artworkUrl));
        track.setDownloadable(trackJson.optBoolean(Track.TrackEntity.DOWNLOADABLE));
        track.setDownloadURL(trackJson.optString(Track.TrackEntity.DOWNLOAD_URL));
        track.setDuration(trackJson.optInt(Track.TrackEntity.DURATION));
        track.setID(trackJson.optInt(Track.TrackEntity.ID));
        track.setSongURI(trackJson.optString(Track.TrackEntity.SONGURI));
        track.setTitle(trackJson.optString(Track.TrackEntity.TITLE));
        track.setLikeCount(trackJson.optInt(Track.TrackEntity.LIKES_COUNT));
        track.setPlayCount(trackJson.optInt(Track.TrackEntity.PLAY_COUNT));

        if (jsonUser != null){
            track.setArtist(jsonUser.optString(Track.TrackEntity.USERNAME));
        }
        return track;
    }
}
