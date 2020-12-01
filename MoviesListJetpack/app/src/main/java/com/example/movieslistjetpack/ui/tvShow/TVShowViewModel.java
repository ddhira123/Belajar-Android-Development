package com.example.movieslistjetpack.ui.tvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.CatalogueRepository;

import java.util.List;

public class TVShowViewModel extends ViewModel {
    private final CatalogueRepository catalogueRepository;

    public TVShowViewModel(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    LiveData<List<TVShowEntity>> getTVShows() {
        return catalogueRepository.getAllTVShows();
    }
}
