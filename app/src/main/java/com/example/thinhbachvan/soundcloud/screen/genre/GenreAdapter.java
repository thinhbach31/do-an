package com.example.thinhbachvan.soundcloud.screen.genre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thinhbachvan.soundcloud.R;
import com.example.thinhbachvan.soundcloud.data.model.Genre;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private onGenreSelectListener mListener;
    private List<Genre> mGenres;
    private Context mContext;
    private LayoutInflater mInflater;

    public GenreAdapter(List<Genre> genres, Context context) {
        mGenres = genres;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null){
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        View view = mInflater.inflate(R.layout.item_genre, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Genre genre = mGenres.get(i);
        viewHolder.bindView(genre, mListener);
    }

    @Override
    public int getItemCount() {
        return mGenres == null ? 0 : mGenres.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageGenre;
        private TextView mTextGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageGenre = itemView.findViewById(R.id.image_genre);
            mTextGenre  = itemView.findViewById(R.id.text_genreName);
        }

        public void bindView(final Genre genre, final onGenreSelectListener listener){
            mTextGenre.setText(genre.getTitleResource());
            Glide.with(mImageGenre).load(genre.getImageResource()).into(mImageGenre);
            mImageGenre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onGenreSelected(genre.getApiName());
                }
            });
        }
    }

    public void setGenres(List<Genre> genres) {
        this.mGenres = genres;
        notifyDataSetChanged();
    }

    public void setOnGenreClickListener(onGenreSelectListener listener){
        mListener = listener;
    }

    public interface onGenreSelectListener{
        void onGenreSelected(String genre);
    }

}
