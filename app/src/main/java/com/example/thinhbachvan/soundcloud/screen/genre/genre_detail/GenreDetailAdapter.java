package com.example.thinhbachvan.soundcloud.screen.genre.genre_detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thinhbachvan.soundcloud.OnClickSongListener;
import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.TrackListener;
import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.ArrayList;
import java.util.List;

public class GenreDetailAdapter extends RecyclerView.Adapter<GenreDetailAdapter.ViewHolder> {

    private TrackListener mTrackListener;
    private List<Track> mTracks;
    private LayoutInflater mInflater;
    private OnClickSongListener mClickSongListener;
    private Context mContext;

    public GenreDetailAdapter(TrackListener trackListener, OnClickSongListener clickSongListener,
                              Context context) {
        mTrackListener = trackListener;
        mClickSongListener = clickSongListener;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setClickSongListener(OnClickSongListener clickSongListener) {
        mClickSongListener = clickSongListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_song_online, viewGroup, false);
        return new ViewHolder(view, mTrackListener, mClickSongListener, mTracks);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mTracks.get(i));
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    public void updateListTrack(List<Track> tracks){
        if (tracks == null) return;
        if (mTracks == null){
            mTracks = new ArrayList<>();
        }
        int startPossition = mTracks.size();
        mTracks.addAll(tracks);
        notifyItemRangeInserted(startPossition, tracks.size());
    }

    public void clearData(){
        if (mTracks != null){
            mTracks.clear();
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageSong, mImagePlaying;
        private TextView mTextSongName, mTextArtist, mTextLikeCount;
        private Track mCurrentTrack;
        private TrackListener mTrackListener;
        private OnClickSongListener mSongListener;
        private Context mContext;
        private ImageButton mButtonDownload, mButtonLike;
        private List<Track> mTracks;

        public ViewHolder(@NonNull View itemView, TrackListener trackListener,
                          OnClickSongListener clickSongListener, List<Track> tracks) {
            super(itemView);
            initView(itemView);
            this.mTrackListener = trackListener;
            this.mSongListener = clickSongListener;
            this.mTracks = tracks;

            mButtonDownload.setOnClickListener(this);
            mButtonLike.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        private void initView(View itemView) {
            mImageSong = itemView.findViewById(R.id.image_songOnline);
            mImagePlaying = itemView.findViewById(R.id.image_playOnline);
            mTextSongName = itemView.findViewById(R.id.text_onlineSongName);
            mTextArtist = itemView.findViewById(R.id.text_onlineSongArtist);
            mTextLikeCount = itemView.findViewById(R.id.text_likeCount);
            mButtonDownload = itemView.findViewById(R.id.button_downloadOnline);
            mButtonLike = itemView.findViewById(R.id.button_likeOnlineSong);
            this.mContext = itemView.getContext();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_downloadOnline:
                    mTrackListener.onDownloadTrack(mCurrentTrack);
                    break;
                case R.id.button_likeOnlineSong:
                    mTrackListener.onLikeTrack(mCurrentTrack);
                    break;
                default:
                    if (mClickSongListener == null) return;
                    mClickSongListener.onItemSongClick(mTracks, getAdapterPosition());
                    break;
            }
        }

        private void bindData(Track track){
            if (track == null) return;
            mCurrentTrack = track;
            Glide.with(mContext).load(mCurrentTrack.getArtworkURL()).into(mImageSong);
            mTextSongName.setText(mCurrentTrack.getTitle());
            mTextArtist.setText(mCurrentTrack.getArtist().getName());
            mTextLikeCount.setText(mCurrentTrack.getLikeCount());
        }
    }
}
