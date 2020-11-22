package com.example.movieslistjetpack.utils;

import android.content.Context;
import android.graphics.Movie;

import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private String parsingFileToString(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieResponse> loadMovies() {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("MovieResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("movies");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject movie = listArray.getJSONObject(i);

                    String id = movie.getString("id");
                    String title = movie.getString("title");
                    String storyLine = movie.getString("storyline");
                    String year = movie.getString("year");
                    String rating = movie.getString("rating");
                    String genre = movie.getString("genre");
                    String stars = movie.getString("stars");
                    String imagePath = movie.getString("imagePath");

                    MovieResponse movieResponse = new MovieResponse(id, title, storyLine, year, stars, genre, rating, imagePath);
                    list.add(movieResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<TVShowResponse> loadTVShows() {
        ArrayList<TVShowResponse> list = new ArrayList<>();
        try {
            String json = parsingFileToString("TVShowResponses.json");
            if (json != null) {
                JSONObject responseObject = new JSONObject(json);
                JSONArray listArray = responseObject.getJSONArray("tvShows");
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject tvShow = listArray.getJSONObject(i);

                    String id = tvShow.getString("id");
                    String title = tvShow.getString("title");
                    String storyLine = tvShow.getString("storyline");
                    String genre = tvShow.getString("genre");
                    String year = tvShow.getString("year");
                    String stars = tvShow.getString("stars");
                    String rating = tvShow.getString("rating");
                    String imagePath = tvShow.getString("imagePath");

                    TVShowResponse tvShowResponse = new TVShowResponse(id, title, storyLine, genre, year, stars, rating, imagePath);
                    list.add(tvShowResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
