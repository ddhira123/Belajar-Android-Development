package com.example.movieslistjetpack.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.remote.RemoteDataSource;
import com.example.movieslistjetpack.data.source.remote.response.MovieResponse;
import com.example.movieslistjetpack.data.source.remote.response.TVShowResponse;
import com.example.movieslistjetpack.utils.DataDummy;
import com.example.movieslistjetpack.utils.LiveDataTestUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogueRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private final RemoteDataSource remoteDataSource = Mockito.mock(RemoteDataSource.class);
    private final FakeCatalogueRepository catalogueRepository = new FakeCatalogueRepository(remoteDataSource);

    private final List<MovieResponse> movieResponses = DataDummy.generateRemoteDummyMovies();
    private final String movieId = movieResponses.get(0).getMovieId();
    private final List<TVShowResponse> tvShowResponses = DataDummy.generateRemoteDummyTVShows();
    private final String tvShowId = tvShowResponses.get(0).getTVShowId();

    @Test
    public void getAllMovies() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        List<MovieEntity> movieEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllMovies());
        verify(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        assertNotNull(movieEntities);
        assertEquals(movieResponses.size(), movieEntities.size());
    }

    @Test
    public void getMovieById() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadMoviesCallback) invocation.getArguments()[0])
                    .onAllMoviesReceived(movieResponses);
            return null;
        }).when(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
        MovieEntity movieEntity = LiveDataTestUtil.getValue(catalogueRepository.getMovieById(movieId));
        verify(remoteDataSource).getAllMovies(any(RemoteDataSource.LoadMoviesCallback.class));
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
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTVShowsCallback) invocation.getArguments()[0])
                    .onAllTVShowsReceived(tvShowResponses);
            return null;
        }).when(remoteDataSource).getAllTVShows(any(RemoteDataSource.LoadTVShowsCallback.class));
        List<TVShowEntity> tvShowEntities = LiveDataTestUtil.getValue(catalogueRepository.getAllTVShows());
        verify(remoteDataSource).getAllTVShows(any(RemoteDataSource.LoadTVShowsCallback.class));
        assertNotNull(tvShowEntities);
        assertEquals(tvShowResponses.size(), tvShowEntities.size());
    }

    @Test
    public void getTVShowById() {
        doAnswer(invocation -> {
            ((RemoteDataSource.LoadTVShowsCallback) invocation.getArguments()[0])
                    .onAllTVShowsReceived(tvShowResponses);
            return null;
        }).when(remoteDataSource).getAllTVShows(any(RemoteDataSource.LoadTVShowsCallback.class));
        TVShowEntity tvShowEntity = LiveDataTestUtil.getValue(catalogueRepository.getTVShowById(tvShowId));
        verify(remoteDataSource).getAllTVShows(any(RemoteDataSource.LoadTVShowsCallback.class));
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