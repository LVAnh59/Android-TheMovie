package com.lvanh.themovie.ui.discover;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lvanh.themovie.Helper;
import com.lvanh.themovie.R;
import com.lvanh.themovie.model.MyMovie;

import java.util.List;

public class CardMovieHorizontalAdapter extends RecyclerView.Adapter<CardMovieHorizontalAdapter.ItemViewAdapter> {
    private List<MyMovie> listData;

    public CardMovieHorizontalAdapter(List<MyMovie> listData) {
        this.listData = listData;
    }


    @NonNull
    @Override
    public ItemViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardMovieHorizontalAdapter.ItemViewAdapter(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie_horizontal,parent,false)
        );
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewAdapter holder, int position) {
        holder.setView(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemViewAdapter extends RecyclerView.ViewHolder{
        private ImageView imgPosterView;
        private TextView txtVoteAverage;
        private TextView txtTitle;
        private TextView txtReleaseDate;

        public ItemViewAdapter(@NonNull View itemView) {
            super(itemView);
            this.imgPosterView = itemView.findViewById(R.id.img_poster);
            this.txtVoteAverage = itemView.findViewById(R.id.txt_vote);
            this.txtTitle = itemView.findViewById(R.id.txt_title);
            this.txtReleaseDate = itemView.findViewById(R.id.txt_release_date);
        }
        public void setView(MyMovie movie) {
            new Helper.DownloadImageTask(imgPosterView).execute(Helper.BASE_URL + movie.getPosterPath());
            txtVoteAverage.setText(String.valueOf((int) (movie.getVote_average()*10)));
            txtTitle.setText(movie.getTitle());
            txtReleaseDate.setText(movie.getReleaseDate().toString());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
