package com.assignment.bigstep.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.assignment.bigstep.R;
import com.assignment.bigstep.model.MusicDescDatabaseModel;

import java.util.List;

public class VideoHistoryAdapter extends RecyclerView.Adapter<VideoHistoryAdapter.MyViewHolder> {


    private List<MusicDescDatabaseModel> dataSet;
    private Context mContext;

    public VideoHistoryAdapter(Context context, List<MusicDescDatabaseModel> data) {
        this.mContext = context;
        this.dataSet = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_history, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view, mContext);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.artistNameHistory.setText(dataSet.get(listPosition).getArtistName());
        holder.trackNamesHistory.setText(dataSet.get(listPosition).getTrackName());
        //    holder.imageViewIconHistory.setImage
        //  holder.collectionNameHistory.setText(dataSet.get(listPosition).getCollectionName());
        holder.collectionPriceHistory.setText(dataSet.get(listPosition).getPrice().toString());
        holder.primaryGenreNameHistory.setText(dataSet.get(listPosition).getGenere());

        // set Imageview


        Glide.with(mContext)
                .load(dataSet.get(listPosition).getImageUrl())
                .placeholder(R.drawable.loading)
                .into(holder.imageViewIconHistory);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView trackNamesHistory;
        private TextView artistNameHistory;
        private ImageView imageViewIconHistory;
        /*    private TextView collectionNameHistory;*/
        private TextView collectionPriceHistory;
        private TextView primaryGenreNameHistory;


        public MyViewHolder(View itemView, Context mContext) {
            super(itemView);
            this.trackNamesHistory = itemView.findViewById(R.id.trackNamesHistory);

            this.artistNameHistory = itemView.findViewById(R.id.artistNameHistory);

                   this.imageViewIconHistory = itemView.findViewById(R.id.imageViewHistory);

            this.collectionPriceHistory = itemView.findViewById(R.id.collectionPriceHistory);

            this.primaryGenreNameHistory = itemView.findViewById(R.id.primaryGenreNameHistory);

        }


    }
}
