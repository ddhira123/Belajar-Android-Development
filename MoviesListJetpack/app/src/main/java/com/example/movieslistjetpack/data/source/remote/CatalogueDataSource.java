package com.example.movieslistjetpack.data.source.remote;

import androidx.lifecycle.LiveData;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;

import java.util.List;

public interface CatalogueDataSource {
    LiveData<List<MovieEntity>> getAllMovies();
    LiveData<MovieEntity> getMovieById(String id);
    LiveData<List<TVShowEntity>> getAllTVShows();
    LiveData<TVShowEntity> getTVShowById(String id);
}
