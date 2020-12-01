package com.example.movieslistjetpack.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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
    public LiveData<List<MovieEntity>> getAllMovies() {
        MutableLiveData<List<MovieEntity>> movieResults = new MutableLiveData<>();
        remoteDataSource.getAllMovies(movieResponses -> {
            ArrayList < MovieEntity > movieList = new ArrayList<>();
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
            movieResults.postValue(movieList);
        });
        return movieResults;
    }

    @Override
    public LiveData<MovieEntity> getMovieById(String id) {
        MutableLiveData<MovieEntity> movieEntityResult = new MutableLiveData<>();
        remoteDataSource.getAllMovies(movieResponses -> {
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
            movieEntityResult.postValue(movieEntity);
        });

        return movieEntityResult;
    }

    @Override
    public LiveData<List<TVShowEntity>> getAllTVShows() {
        MutableLiveData<List<TVShowEntity>> tvShowResults = new MutableLiveData<>();
        remoteDataSource.getAllTVShows(tvShowResponses -> {
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
            tvShowResults.postValue(tvShowList);
        });

        return tvShowResults;
    }

    @Override
    public LiveData<TVShowEntity> getTVShowById(String id) {
        MutableLiveData<TVShowEntity> tvShowEntityResult = new MutableLiveData<>();
        remoteDataSource.getAllTVShows(tvShowResponses -> {
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
            tvShowEntityResult.postValue(tvShowEntity);
        });

        return tvShowEntityResult;
    }
}
