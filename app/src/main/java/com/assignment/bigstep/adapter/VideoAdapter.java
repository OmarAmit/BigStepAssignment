package com.assignment.bigstep.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.bigstep.R;
import com.assignment.bigstep.view.activity.DescActivity;
import com.assignment.bigstep.databinding.MusicListItemBinding;
import com.assignment.bigstep.model.Video;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MusicViewHolder> {

    private Context context;
    private ArrayList<Video> musicArrayList;

    public VideoAdapter(Context context, ArrayList<Video> musicArrayList) {
        this.context = context;
        this.musicArrayList = musicArrayList;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MusicListItemBinding musicListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.music_list_item, parent, false);

        return new MusicViewHolder(musicListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

        Video music = musicArrayList.get(position);
        holder.musicListItemBinding.setMusic(music);
    }

    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        private MusicListItemBinding musicListItemBinding;

        public MusicViewHolder(@NonNull MusicListItemBinding musicListItemBinding) {
            super(musicListItemBinding.getRoot());
            this.musicListItemBinding = musicListItemBinding;

            musicListItemBinding.getRoot().setOnClickListener(v -> {

                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION) {
                    Video selctedMusic = musicArrayList.get(position);
                    Intent intent = new Intent(context, DescActivity.class);
                    intent.putExtra("music", selctedMusic);
                    context.startActivity(intent);

                }
            });
        }
    }
}
