package com.example.movieslistjetpack.data.source.remote;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;

import java.util.List;

public interface CatalogueDataSource {
    List<MovieEntity> getAllMovies();
    MovieEntity getMovieById(String id);
    List<TVShowEntity> getAllTVShows();
    TVShowEntity getTVShowById(String id);
}
