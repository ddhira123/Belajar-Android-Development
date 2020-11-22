package com.example.movieslistjetpack.ui.tvShow;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {
    private final List<TVShowEntity> listTVShows = new ArrayList<>();

    void setTVShows(List<TVShowEntity> listTVShows) {
        if (listTVShows == null) return;
        this.listTVShows.clear();
        this.listTVShows.addAll(listTVShows);
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_component, parent, false);
        return new TVShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TVShowViewHolder holder, int position) {
        TVShowEntity tvShow = listTVShows.get(position);
        holder.bind(tvShow);
    }

    @Override
    public int getItemCount() {
        return listTVShows.size();
    }

    static class TVShowViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvYear;
        final ImageView imgPoster;

        TVShowViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvYear = itemView.findViewById(R.id.tv_item_year);
        }

        void bind(TVShowEntity tvShow) {
            tvTitle.setText(tvShow.getTitle());
            tvYear.setText(tvShow.getYear());
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TVSHOW, tvShow.getId());
                itemView.getContext().startActivity(intent);
            });
            Glide.with(itemView.getContext())
                    .load(tvShow.getImgPath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPoster);
        }
    }
}