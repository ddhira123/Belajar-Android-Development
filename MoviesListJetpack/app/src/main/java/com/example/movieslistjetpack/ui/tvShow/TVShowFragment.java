package com.example.movieslistjetpack.ui.tvShow;

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
import com.example.movieslistjetpack.viewmodel.ViewModelFactory;

public class TVShowFragment extends Fragment {
    private RecyclerView rvTVShow;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTVShow = view.findViewById(R.id.rv_items);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TVShowViewModel tvShowViewModel = new ViewModelProvider(this, factory).get(TVShowViewModel.class);
            TVShowAdapter tvShowAdapter = new TVShowAdapter();
            progressBar.setVisibility(View.VISIBLE);
            tvShowViewModel.getTVShows().observe(getViewLifecycleOwner(), tvShows -> {
                        progressBar.setVisibility(View.GONE);
                        tvShowAdapter.setTVShows(tvShows);
                        tvShowAdapter.notifyDataSetChanged();
                    }
            );
            rvTVShow.setLayoutManager(new GridLayoutManager(getContext(), 2));
            rvTVShow.setHasFixedSize(true);
            rvTVShow.setAdapter(tvShowAdapter);
        }
    }
}