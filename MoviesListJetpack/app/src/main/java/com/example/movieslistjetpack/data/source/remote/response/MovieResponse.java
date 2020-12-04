package com.example.movieslistjetpack.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String movieId;
    private String title;
    private String storyline;
    private String year;
    private String stars;
    private String genre;
    private String rating;
    private String imgPath;

    public MovieResponse(String movieId, String title, String storyline, String year, String stars, String genre, String rating, String imgPath) {
        this.movieId = movieId;
        this.title = title;
        this.storyline = storyline;
        this.year = year;
        this.stars = stars;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
    }

    protected MovieResponse(Parcel in) {
        movieId = in.readString();
        title = in.readString();
        storyline = in.readString();
        year = in.readString();
        stars = in.readString();
        genre = in.readString();
        rating = in.readString();
        imgPath = in.readString();
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getStoryline() {
        return storyline;
    }

    public String getYear() {
        return year;
    }

    public String getStars() {
        return stars;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public String getImgPath() {
        return imgPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieId);
        dest.writeString(this.title);
        dest.writeString(this.storyline);
        dest.writeString(this.stars);
        dest.writeString(this.genre);
        dest.writeString(this.rating);
        dest.writeString(this.imgPath);
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}
