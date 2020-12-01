package com.example.movieslistjetpack.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.CatalogueRepository;

public class DetailViewModel extends ViewModel {
    private String id;
    private final CatalogueRepository catalogueRepository;

    public DetailViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public void setSelected(String id) {
        this.id = id;
    }

    public LiveData<MovieEntity> getMovie() {
        return catalogueRepository.getMovieById(this.id);
    }

    public LiveData<TVShowEntity> getTVShow() {
        return catalogueRepository.getTVShowById(this.id);
    }
}
