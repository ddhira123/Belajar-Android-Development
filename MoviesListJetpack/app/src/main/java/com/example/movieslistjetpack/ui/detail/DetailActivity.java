package com.example.movieslistjetpack.ui.detail;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.viewmodel.ViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.MessageFormat;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TVSHOW = "extra_tvShow";
    private String title;
    private TextView textTitle;
    private TextView textStoryline;
    private TextView textYear;
    private TextView textStars;
    private TextView textRating;
    private TextView textGenre;
    private ImageView imagePoster;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        progressBar = findViewById(R.id.progress_bar);
        textTitle = findViewById(R.id.text_title);
        textYear = findViewById(R.id.text_year);
        textStars = findViewById(R.id.text_stars);
        textStoryline = findViewById(R.id.text_storyline);
        textRating = findViewById(R.id.text_rating);
        textGenre = findViewById(R.id.text_genre_list);
        imagePoster = findViewById(R.id.image_poster);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailViewModel viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String movieId = extras.getString(EXTRA_MOVIE);
            String tvShowId = extras.getString(EXTRA_TVSHOW);
            progressBar.setVisibility(View.VISIBLE);
            if (movieId != null) {
                viewModel.setSelected(movieId);
                viewModel.getMovie().observe(this,this::populateMovie );
                title = "Detail Movie";
            } else if(tvShowId != null){
                viewModel.setSelected(tvShowId);
                viewModel.getTVShow().observe(this, this::populateTVShow);
                title = "Detail TV Show";
            }
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }

    private void populateMovie(MovieEntity movieEntity) {
        Glide.with(this)
                .load(movieEntity.getImgPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(movieEntity.getTitle());
        textStoryline.setText(movieEntity.getStoryline());
        textRating.setText(MessageFormat.format("{0} / 10", movieEntity.getRating()));
        textStars.setText(movieEntity.getStars());
        textGenre.setText(movieEntity.getGenre());
        textYear.setText(movieEntity.getYear());

        textTitle.setVisibility(View.VISIBLE);
        textStoryline.setVisibility(View.VISIBLE);
        textRating.setVisibility(View.VISIBLE);
        textStars.setVisibility(View.VISIBLE);
        textGenre.setVisibility(View.VISIBLE);
        textYear.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    private void populateTVShow(TVShowEntity tvShowEntity) {
        Glide.with(this)
                .load(tvShowEntity.getImgPath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster);
        textTitle.setText(tvShowEntity.getTitle());
        textStoryline.setText(tvShowEntity.getStoryline());
        textRating.setText(tvShowEntity.getRating());
        textRating.setText(MessageFormat.format("{0} / 10", tvShowEntity.getRating()));
        textGenre.setText(tvShowEntity.getGenre());
        textStars.setText(tvShowEntity.getStars());
        textYear.setText(tvShowEntity.getYear());

        textTitle.setVisibility(View.VISIBLE);
        textStoryline.setVisibility(View.VISIBLE);
        textRating.setVisibility(View.VISIBLE);
        textStars.setVisibility(View.VISIBLE);
        textGenre.setVisibility(View.VISIBLE);
        textYear.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}