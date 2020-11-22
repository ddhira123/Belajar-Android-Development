package com.example.movieslistjetpack.data.source;

import android.util.Log;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.remote.CatalogueDataSource;
import com.example.movieslistjetpack.data.source.remote.RemoteDataSource;
import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;

import java.util.ArrayList;
import java.util.List;

public class CatalogueRepository implements CatalogueDataSource {

    private volatile static CatalogueRepository INSTANCE = null;

    private final RemoteDataSource remoteDataSource;

    public CatalogueRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static CatalogueRepository getINSTANCE(RemoteDataSource remoteData) {
        if(INSTANCE == null){
            synchronized (CatalogueRepository.class){
                if(INSTANCE == null) {
                    INSTANCE = new CatalogueRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        List<MovieResponse> movieResponses = remoteDataSource.getAllMovies();
        ArrayList<MovieEntity> movieList = new ArrayList<>();
        for (MovieResponse response : movieResponses) {
            MovieEntity movieEntity = new MovieEntity(response.getMovieId(),
                    response.getTitle(),
                    response.getStoryline(),
                    response.getYear(),
                    response.getStars(),
                    response.getGenre(),
                    response.getRating(),
                    response.getImgPath());

            movieList.add(movieEntity);
        }
        return movieList;
    }

    @Override
    public MovieEntity getMovieById(String id) {
        List<MovieResponse> movieResponses = remoteDataSource.getAllMovies();
        MovieEntity movieEntity = null;
        for (MovieResponse response : movieResponses) {
            if(response.getMovieId().equals(id)){
                movieEntity = new MovieEntity(response.getMovieId(),
                        response.getTitle(),
                        response.getStoryline(),
                        response.getYear(),
                        response.getStars(),
                        response.getGenre(),
                        response.getRating(),
                        response.getImgPath());
            }
        }
        return movieEntity;
    }

    @Override
    public List<TVShowEntity> getAllTVShows() {
        List<TVShowResponse> tvShowResponses = remoteDataSource.getAllTVShows();
        ArrayList<TVShowEntity> tvShowList = new ArrayList<>();
        for (TVShowResponse response : tvShowResponses) {
            TVShowEntity tvShowEntity = new TVShowEntity(response.getTVShowId(),
                    response.getTitle(),
                    response.getStoryline(),
                    response.getGenre(),
                    response.getYear(),
                    response.getStars(),
                    response.getRating(),
                    response.getImgPath());

            tvShowList.add(tvShowEntity);
        }
        return tvShowList;
    }

    @Override
    public TVShowEntity getTVShowById(String id) {
        List<TVShowResponse> tvShowResponses = remoteDataSource.getAllTVShows();
        TVShowEntity tvShowEntity = null;
        for (TVShowResponse response : tvShowResponses) {
            if(response.getTVShowId().equals(id)){
                tvShowEntity = new TVShowEntity(response.getTVShowId(),
                        response.getTitle(),
                        response.getStoryline(),
                        response.getGenre(),
                        response.getYear(),
                        response.getStars(),
                        response.getRating(),
                        response.getImgPath());
            }
        }
        return tvShowEntity;
    }
}
