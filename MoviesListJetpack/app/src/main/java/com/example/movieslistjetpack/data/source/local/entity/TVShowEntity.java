package com.example.movieslistjetpack.data.source.local.entity;

public class TVShowEntity {

    private final String id;
    private final String title;
    private final String storyline;
    private final String genre;
    private final String year;
    private final String stars;
    private final String rating;
    private final String imgPath;

    public TVShowEntity(String id, String title, String storyline, String genre, String year, String stars, String rating, String imgPath) {
        this.id = id;
        this.title = title;
        this.storyline = storyline;
        this.genre = genre;
        this.year = year;
        this.stars = stars;
        this.rating = rating;
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public String getStoryline() {
        return storyline;
    }

    public String getGenre() {
        return genre;
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

    public String getImgPath() {
        return imgPath;
    }

    public String getId() {
        return id;
    }

}
