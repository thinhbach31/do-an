package com.example.thinhbachvan.soundcloud.screen.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thinhbachvan.soundcloud.OnClickSongListener;
import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Track;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {

    private List<Track> mTracks;
    private OnClickSongListener mListener;
    //private LayoutInflater mInflater;
    private Context mContext;

    public LibraryAdapter(OnClickSongListener listener, Context context) {
        mListener = listener;
        mContext = context;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.items_song_offline, viewGroup, false);
        return new ViewHolder(view, mListener, mTracks);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mTracks.get(i));
    }

    @Override
    public int getItemCount() {
        return mTracks != null ? mTracks.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextSongName, mTextArtist;
        private ImageView mImageSong;
        private OnClickSongListener mListener;
        private List<Track> mTracks;
        private Context mContext;

        public ViewHolder(@NonNull View itemView, OnClickSongListener listener,
                          List<Track> tracks) {
            super(itemView);

            this.mListener = listener;
            this.mTracks = tracks;
            this.mContext = itemView.getContext();
            mTextSongName = itemView.findViewById(R.id.text_onlineSongName);
            mTextArtist = itemView.findViewById(R.id.text_onlineSongArtist);
            mImageSong = itemView.findViewById(R.id.image_offlineSong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener == null) return;
                    mListener.onItemSongClick(mTracks, getLayoutPosition());
                }
            });
        }

        private void bindData(Track track){
            mTextSongName.setText(track.getTitle());
            mTextArtist.setText(track.getArtist().getName());
        }
    }
}
