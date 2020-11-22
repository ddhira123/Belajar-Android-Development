package com.example.movieslistjetpack.ui.tvShow;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.data.source.FakeCatalogueRepository;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TVShowViewModelTest {

    private TVShowViewModel tvShowViewModel;

    @Mock
    private CatalogueRepository catalogueRepository;

    @Before
    public void setUp() {
        tvShowViewModel = new TVShowViewModel(catalogueRepository);
    }

    @Test
    public void getTVShows() {
        when(catalogueRepository.getAllTVShows()).thenReturn(DataDummy.generateDummyTVShows());
        List<TVShowEntity> movies = tvShowViewModel.getTVShows();
        verify(catalogueRepository).getAllTVShows();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }
}