package com.example.movieslistjetpack.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.di.Injection;
import com.example.movieslistjetpack.ui.detail.DetailViewModel;
import com.example.movieslistjetpack.ui.movie.MovieViewModel;
import com.example.movieslistjetpack.ui.tvShow.TVShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final CatalogueRepository catalogueRepository;

    public ViewModelFactory(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public static ViewModelFactory getInstance(Context context){
        if(INSTANCE == null){
            synchronized (ViewModelFactory.class){
                if(INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(TVShowViewModel.class)) {
            return (T) new TVShowViewModel(catalogueRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(catalogueRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
