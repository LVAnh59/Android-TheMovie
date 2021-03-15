package com.lvanh.themovie.ui.discover;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lvanh.themovie.Helper;
import com.lvanh.themovie.R;
import com.lvanh.themovie.model.MyMovie;

import java.util.ArrayList;
import java.util.List;

public class CardMovieAdapter extends BaseAdapter {
    private List<MyMovie> listTopRated;

    public CardMovieAdapter(MyMovie myMovie1, MyMovie myMovie2) {
        this.listTopRated = new ArrayList<>();
        if (myMovie1 != null) this.listTopRated.add(myMovie1);
        if (myMovie2 != null) this.listTopRated.add(myMovie2);
    }

    @Override
    public int getCount() {
        return listTopRated.size();
    }

    @Override
    public Object getItem(int i) {
        return listTopRated.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null){
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_movie,viewGroup,false);
            ImageView imgPosterView = v.findViewById(R.id.img_poster);
            TextView txtVoteAverage = v.findViewById(R.id.txt_vote);
            TextView txtTitle = v.findViewById(R.id.txt_title);
            TextView txtReleaseDate = v.findViewById(R.id.txt_release_date);

            new Helper.DownloadImageTask(imgPosterView).execute(Helper.BASE_URL + listTopRated.get(i).getPosterPath());
            txtVoteAverage.setText(String.valueOf((int) (listTopRated.get(i).getVote_average()*10)));
            txtTitle.setText(listTopRated.get(i).getTitle());
            txtReleaseDate.setText(listTopRated.get(i).getReleaseDate().toString());
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        return v;
    }
}
