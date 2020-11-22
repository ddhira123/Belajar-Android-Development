package com.example.movieslistjetpack.ui.movie;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.FakeCatalogueRepository;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
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

    @Mock
    private CatalogueRepository catalogueRepository;

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(catalogueRepository);
    }

    @Test
    public void getMovies() {
        when(catalogueRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies());
        List<MovieEntity> movies = movieViewModel.getMovies();
        verify(catalogueRepository).getAllMovies();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }
}