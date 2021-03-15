package com.lvanh.themovie.ui.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.HorizontalGridView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.lvanh.themovie.Helper;
import com.lvanh.themovie.R;
import com.lvanh.themovie.model.MyMovie;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_discover, container, false);
        ViewPager2 viewPager2 = root.findViewById(R.id.vpi_hot_movie);
        List<String> itemHotMovies = new ArrayList<>();
        itemHotMovies.add("https://image.tmdb.org/t/p/w500/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/w500/fev8UFNFFYsD5q7AcYS8LyTzqwl.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/w500/vKzbIoHhk1z9DWYi8kyFe9Gg0HF.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/w500/8tNX8s3j1O0eqilOQkuroRLyOZA.jpg");
        itemHotMovies.add("https://image.tmdb.org/t/p/w500/srYya1ZlI97Au4jUYAktDe3avyA.jpg");
        viewPager2.setAdapter(new ItemHotMovieAdapter(itemHotMovies,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View view, final float position) {
                int pageWidth = view.getWidth();
                final float MIN_SCALE = 0.6f;
                final float MAX_SCALE = 0.8f;
                final float MIN_FADE = 0.3f;
                if (position < -1) {
                    view.setAlpha(MIN_FADE);
                } else if (position < 0) {
                    view.setAlpha(1 + position * (1 - MIN_FADE));
                    view.setTranslationX(-pageWidth * MAX_SCALE * position);
                    ViewCompat.setTranslationZ(view, position);
                    float scaleFactor = MIN_SCALE
                            + (MAX_SCALE - MIN_SCALE) * (1 - Math.abs(position));
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else if (position == 0) {
                    view.setAlpha(1);
                    view.setTranslationX(0);
                    view.setScaleX(MAX_SCALE);
                    ViewCompat.setTranslationZ(view, 0);
                    view.setScaleY(MAX_SCALE);
                } else if (position <= 1) {
                    ViewCompat.setTranslationZ(view, -position);
                    view.setAlpha(1 - position * (1 - MIN_FADE));
                    view.setTranslationX(pageWidth * MAX_SCALE * -position);

                    float scaleFactor = MIN_SCALE
                            + (MAX_SCALE - MIN_SCALE) * (1 - Math.abs(position));
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                } else {
                    view.setAlpha(MIN_FADE);
                }
//                view.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Log.e("myLog", String.valueOf(view.getId()));
//                    }
//                });
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        //new movie in week
        List<MyMovie> listMovie = getListData();
        HorizontalGridView gridNewMovieInWeek =  root.findViewById(R.id.grd_new_movie_in_week);
        gridNewMovieInWeek.setAdapter(new CardMovieHorizontalAdapter(listMovie));

//        GridView gridTopRated = root.findViewById(R.id.grd_top_rated);
//        gridTopRated.setAdapter(new CardMovieAdapter(listMovie));
        LinearLayout lnlDiscover = root.findViewById(R.id.lnl_discover);

        for (int i = 0; i<listMovie.size();i = i + 2) {
            GridView gridTopRated = new GridView(getContext());
            gridTopRated.setNumColumns(2);
            gridTopRated.setHorizontalSpacing((int) Helper.pxFromDp(getContext(), 10));
            gridTopRated.setVerticalSpacing((int) Helper.pxFromDp(getContext(), 20));
            int gridPadding = (int) Helper.pxFromDp(getContext(), 24);
            gridTopRated.setPadding(gridPadding, gridPadding, gridPadding, 0);
            if(i+1>=listMovie.size()){
                    gridTopRated.setAdapter(new CardMovieAdapter(listMovie.get(i),null));


            }
            else {
                gridTopRated.setAdapter(new CardMovieAdapter(listMovie.get(i),listMovie.get(i+1)));
            }
            lnlDiscover.addView(gridTopRated);
        }

        return root;
    }
    private  List<MyMovie> getListData() {
        List<MyMovie> listMovie = new ArrayList<>();
        MyMovie myMovie1 = new MyMovie("Greenlandb","/bNo2mcvSwIvnx8K6y1euAc1TLVq.jpg",
                "2020-07-29",7.3f);
        MyMovie myMovie2 = new MyMovie("Greenlandb hgg hlk asd asd hadakjk daksk dasdasd sa dsad sa","/bNo2mcvSwIvnx8K6y1euAc1TLVq.jpg",
                "2020-07-29",7.3f);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie2);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        listMovie.add(myMovie1);
        return listMovie;
    }
}