package com.example.movieslistjetpack.data.source;

import android.util.Log;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.remote.RemoteDataSource;
import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogueRepositoryTest {

    private final RemoteDataSource remoteDataSource = Mockito.mock(RemoteDataSource.class);
    private final FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(remoteDataSource);

    private final List<MovieResponse> movieResponses = DataDummy.generateRemoteDummyMovies();
    private final String movieId = movieResponses.get(0).getMovieId();
    private final List<TVShowResponse> tvShowResponses = DataDummy.generateRemoteDummyTVShows();
    private final String tvShowId = tvShowResponses.get(0).getTVShowId();

    @Test
    public void getAllMovies() {
        when(remoteDataSource.getAllMovies()).thenReturn(movieResponses);
        List<MovieEntity> movieEntities = catalogueRepository.getAllMovies();
        verify(remoteDataSource).getAllMovies();
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getMovieById() {
        when(remoteDataSource.getAllMovies()).thenReturn(movieResponses);
        MovieEntity movieEntity = catalogueRepository.getMovieById(movieId);
        verify(remoteDataSource).getAllMovies();
        assertNotNull(movieEntity);
        assertEquals(movieResponses.get(0).getMovieId(), movieEntity.getMovieId());
        assertEquals(movieResponses.get(0).getTitle(), movieEntity.getTitle());
        assertEquals(movieResponses.get(0).getYear(), movieEntity.getYear());
        assertEquals(movieResponses.get(0).getGenre(), movieEntity.getGenre());
        assertEquals(movieResponses.get(0).getRating(), movieEntity.getRating());
        assertEquals(movieResponses.get(0).getStoryline(), movieEntity.getStoryline());
        assertEquals(movieResponses.get(0).getImgPath(), movieEntity.getImgPath());
        assertEquals(movieResponses.get(0).getStars(), movieEntity.getStars());
    }

    @Test
    public void getAllTVShows() {
        when(remoteDataSource.getAllTVShows()).thenReturn(tvShowResponses);
        List<TVShowEntity> tvShowEntities = catalogueRepository.getAllTVShows();
        verify(remoteDataSource).getAllTVShows();
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.size());
    }

    @Test
    public void getTVShowById() {
        when(remoteDataSource.getAllTVShows()).thenReturn(tvShowResponses);
        TVShowEntity tvShowEntity = catalogueRepository.getTVShowById(tvShowId);
        verify(remoteDataSource).getAllTVShows();
        assertNotNull(tvShowEntity);
        assertEquals(tvShowResponses.get(0).getTVShowId(), tvShowEntity.getId());
        assertEquals(tvShowResponses.get(0).getTitle(), tvShowEntity.getTitle());
        assertEquals(tvShowResponses.get(0).getYear(), tvShowEntity.getYear());
        assertEquals(tvShowResponses.get(0).getGenre(), tvShowEntity.getGenre());
        assertEquals(tvShowResponses.get(0).getRating(), tvShowEntity.getRating());
        assertEquals(tvShowResponses.get(0).getStoryline(), tvShowEntity.getStoryline());
        assertEquals(tvShowResponses.get(0).getImgPath(), tvShowEntity.getImgPath());
        assertEquals(tvShowResponses.get(0).getStars(), tvShowEntity.getStars());
    }
}