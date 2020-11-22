package com.example.movieslistjetpack.ui.detail;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.FakeCatalogueRepository;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
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

    @Mock
    private CatalogueRepository catalogueRepository;

    @Before
    public void setUp() {
        detailViewModelMovie = new DetailViewModel(catalogueRepository);
        detailViewModelMovie.setSelected(movieId);

        detailViewModelTVShow = new DetailViewModel(catalogueRepository);
        detailViewModelTVShow.setSelected(tvShowId);
    }

    @Test
    public void getMovie() {
        when(catalogueRepository.getMovieById(movieId)).thenReturn(dummyMovie);
        MovieEntity movieEntity = detailViewModelMovie.getMovie();
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
    }

    @Test
    public void getTVShow() {
        when(catalogueRepository.getTVShowById(tvShowId)).thenReturn(dummyTVShow);
        TVShowEntity tvShowEntity = detailViewModelTVShow.getTVShow();
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
    }
}