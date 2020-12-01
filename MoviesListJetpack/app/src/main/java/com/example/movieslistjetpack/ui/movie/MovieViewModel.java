package com.example.movieslistjetpack.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.CatalogueRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private final CatalogueRepository catalogueRepository;

    public MovieViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<List<MovieEntity>> getMovies() {
        return catalogueRepository.getAllMovies();
    }
}
