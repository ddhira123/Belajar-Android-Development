package com.example.movieslistjetpack.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailViewModelTest {

    private DetailViewModel detailViewModelMovie;
    private DetailViewModel detailViewModelTVShow;
    private final MovieEntity dummyMovie = DataDummy.generateDummyMovies().get(0);
    private final String movieId = dummyMovie.getMovieId();
    private final TVShowEntity dummyTVShow = DataDummy.generateDummyTVShows().get(0);
    private final String tvShowId = dummyTVShow.getId();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<MovieEntity> movieObserver;

    @Mock
    private Observer<TVShowEntity> tvShowObserver;

    @Before
    public void setUp() {
        detailViewModelMovie = new DetailViewModel(catalogueRepository);
        detailViewModelMovie.setSelected(movieId);

        detailViewModelTVShow = new DetailViewModel(catalogueRepository);
        detailViewModelTVShow.setSelected(tvShowId);
    }

    @Test
    public void getMovie() {
        MutableLiveData<MovieEntity> movie = new MutableLiveData<>();
        movie.setValue(dummyMovie);
        when(catalogueRepository.getMovieById(movieId)).thenReturn(movie);
        MovieEntity movieEntity = detailViewModelMovie.getMovie().getValue();
        verify(catalogueRepository).getMovieById(movieId);
        assertNotNull(movieEntity);
        assertEquals(dummyMovie.getMovieId(), movieEntity.getMovieId());
        assertEquals(dummyMovie.getTitle(), movieEntity.getTitle());
        assertEquals(dummyMovie.getGenre(), movieEntity.getGenre());
        assertEquals(dummyMovie.getImgPath(), movieEntity.getImgPath());
        assertEquals(dummyMovie.getRating(), movieEntity.getRating());
        assertEquals(dummyMovie.getStars(), movieEntity.getStars());
        assertEquals(dummyMovie.getStoryline(), movieEntity.getStoryline());
        assertEquals(dummyMovie.getYear(), movieEntity.getYear());

        detailViewModelMovie.getMovie().observeForever(movieObserver);
        verify(movieObserver).onChanged(dummyMovie);
    }

    @Test
    public void getTVShow() {
        MutableLiveData<TVShowEntity> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTVShow);
        when(catalogueRepository.getTVShowById(tvShowId)).thenReturn(tvShow);
        TVShowEntity tvShowEntity = detailViewModelTVShow.getTVShow().getValue();
        verify(catalogueRepository).getTVShowById(tvShowId);
        assertNotNull(tvShowEntity);
        assertEquals(dummyTVShow.getId(), tvShowEntity.getId());
        assertEquals(dummyTVShow.getTitle(), tvShowEntity.getTitle());
        assertEquals(dummyTVShow.getGenre(), tvShowEntity.getGenre());
        assertEquals(dummyTVShow.getImgPath(), tvShowEntity.getImgPath());
        assertEquals(dummyTVShow.getRating(), tvShowEntity.getRating());
        assertEquals(dummyTVShow.getStars(), tvShowEntity.getStars());
        assertEquals(dummyTVShow.getStoryline(), tvShowEntity.getStoryline());
        assertEquals(dummyTVShow.getYear(), tvShowEntity.getYear());

        detailViewModelTVShow.getTVShow().observeForever(tvShowObserver);
        verify(tvShowObserver).onChanged(dummyTVShow);
    }
}