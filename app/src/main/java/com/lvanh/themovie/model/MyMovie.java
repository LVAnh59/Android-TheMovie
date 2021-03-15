package com.lvanh.themovie.model;

import java.util.Date;

public class MyMovie {
    private String title;
    private String posterPath;
    private String releaseDate;
    private float vote_average;

    public MyMovie(String title, String posterPath, String releaseDate, float vote_average) {
        this.title = title;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getVote_average() {
        return vote_average;
    }
}
