package com.example.movieslistjetpack.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {

    private MovieViewModel movieViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<List<MovieEntity>> observer;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        List<MovieEntity> dummyMovies = DataDummy.generateDummyMovies();
        MutableLiveData<List<MovieEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(catalogueRepository.getAllMovies()).thenReturn(movies);
        List<MovieEntity> movieEntities = movieViewModel.getMovies().getValue();
        verify(catalogueRepository).getAllMovies();
        assertNotNull(movieEntities);
        assertEquals(10, movieEntities.size());

        movieViewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}