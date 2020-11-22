package com.example.movieslistjetpack.ui.tvShow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.viewmodel.ViewModelFactory;

import java.util.List;

public class TVShowFragment extends Fragment {
    private RecyclerView rvTVShow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTVShow = view.findViewById(R.id.rv_items);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TVShowViewModel tvShowViewModel = new ViewModelProvider(this, factory).get(TVShowViewModel.class);
            List<TVShowEntity> tvShows = tvShowViewModel.getTVShows();
            TVShowAdapter tvShowAdapter = new TVShowAdapter();
            tvShowAdapter.setTVShows(tvShows);
            rvTVShow.setLayoutManager(new GridLayoutManager(getContext(), 2));
            rvTVShow.setHasFixedSize(true);
            rvTVShow.setAdapter(tvShowAdapter);
        }
    }
}