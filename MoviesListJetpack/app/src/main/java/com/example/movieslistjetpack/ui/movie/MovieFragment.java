package com.example.movieslistjetpack.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.viewmodel.ViewModelFactory;

import java.util.List;

public class MovieFragment extends Fragment {
    private RecyclerView rvMovie;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_items);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MovieViewModel movieViewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);
            MovieAdapter movieAdapter = new MovieAdapter();
            progressBar.setVisibility(View.VISIBLE);
            movieViewModel.getMovies().observe(getViewLifecycleOwner(), movies -> {
                    progressBar.setVisibility(View.GONE);
                    movieAdapter.setMovies(movies);
                    movieAdapter.notifyDataSetChanged();
                }
            );
            rvMovie.setLayoutManager(new GridLayoutManager(getContext(), 2));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(movieAdapter);
        }
    }
}