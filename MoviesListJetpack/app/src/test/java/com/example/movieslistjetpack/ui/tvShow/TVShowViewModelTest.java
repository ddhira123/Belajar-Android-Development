package com.example.movieslistjetpack.ui.tvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.movieslistjetpack.data.source.CatalogueRepository;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
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

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private CatalogueRepository catalogueRepository;

    @Mock
    private Observer<List<TVShowEntity>> observer;

    @Before
    public void setUp() {
        tvShowViewModel = new TVShowViewModel(catalogueRepository);
    }

    @Test
    public void getTVShows() {
        List<TVShowEntity> dummyTVShows = DataDummy.generateDummyTVShows();
        MutableLiveData<List<TVShowEntity>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTVShows);

        when(catalogueRepository.getAllTVShows()).thenReturn(tvShows);
        List<TVShowEntity> tvShowEntities = tvShowViewModel.getTVShows().getValue();
        verify(catalogueRepository).getAllTVShows();
        assertNotNull(tvShowEntities);
        assertEquals(10, tvShowEntities.size());

        tvShowViewModel.getTVShows().observeForever(observer);
        verify(observer).onChanged(dummyTVShows);
    }
}