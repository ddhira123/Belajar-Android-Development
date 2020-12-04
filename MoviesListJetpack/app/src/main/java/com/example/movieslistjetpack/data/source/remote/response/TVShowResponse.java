package com.example.movieslistjetpack.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShowResponse implements Parcelable {
    private String id;
    private String title;
    private String storyline;
    private String year;
    private String stars;
    private String genre;
    private String rating;
    private String imgPath;

    public TVShowResponse(String id, String title, String storyline, String genre, String year, String stars, String rating, String imgPath) {
        this.id = id;
        this.title = title;
        this.storyline = storyline;
        this.genre = genre;
        this.year = year;
        this.stars = stars;
        this.rating = rating;
        this.imgPath = imgPath;
    }

    protected TVShowResponse(Parcel in) {
        id = in.readString();
        title = in.readString();
        storyline = in.readString();
        genre = in.readString();
        year = in.readString();
        stars = in.readString();
        rating = in.readString();
        imgPath = in.readString();
    }

    public String getTVShowId() {
        return id;
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
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.storyline);
        dest.writeString(this.genre);
        dest.writeString(this.year);
        dest.writeString(this.stars);
        dest.writeString(this.rating);
        dest.writeString(this.imgPath);
    }

    public static final Creator<TVShowResponse> CREATOR = new Creator<TVShowResponse>() {
        @Override
        public TVShowResponse createFromParcel(Parcel in) {
            return new TVShowResponse(in);
        }

        @Override
        public TVShowResponse[] newArray(int size) {
            return new TVShowResponse[size];
        }
    };
}

