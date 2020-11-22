package com.example.movieslistjetpack.data.source.local.entity;

public class MovieEntity {
    private final String movieId;
    private final String title;
    private final String storyline;
    private final String year;
    private final String stars;
    private final String genre;
    private final String rating;
    private final String imgPath;

    public MovieEntity(String movieId, String title, String storyline, String year, String stars, String genre, String rating, String imgPath) {
        this.movieId = movieId;
        this.title = title;
        this.storyline = storyline;
        this.year = year;
        this.stars = stars;
        this.genre = genre;
        this.rating = rating;
        this.imgPath = imgPath;
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

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getImgPath() {
        return imgPath;
    }

}
