package com.example.movieslistjetpack.data.source.remote;

import android.os.Handler;

import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;
import com.example.movieslistjetpack.utils.EspressoIdlingResource;
import com.example.movieslistjetpack.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private final JsonHelper jsonHelper;
    private final Handler handler = new Handler();
    private final long SERVICE_LATENCY_IN_MILLIS = 2000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

    public void getAllMovies(LoadMoviesCallback loadMoviesCallback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()-> {
            loadMoviesCallback.onAllMoviesReceived(
                    jsonHelper.loadMovies());
                    EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public void getAllTVShows(LoadTVShowsCallback loadTVShowsCallback){
        EspressoIdlingResource.increment();
        handler.postDelayed(()-> {
            loadTVShowsCallback.onAllTVShowsReceived(
                jsonHelper.loadTVShows());
                EspressoIdlingResource.decrement();
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadMoviesCallback {
        void onAllMoviesReceived(List<MovieResponse> movieResponses);
    }

    public interface LoadTVShowsCallback {
        void onAllTVShowsReceived(List<TVShowResponse> tvShowResponses);
    }
}