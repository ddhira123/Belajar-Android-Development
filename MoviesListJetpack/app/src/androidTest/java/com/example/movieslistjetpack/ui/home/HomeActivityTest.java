package com.example.movieslistjetpack.ui.home;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.utils.DataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class HomeActivityTest {

    private final List<MovieEntity> dummyMovies = DataDummy.generateDummyMovies();
    private final List<TVShowEntity> dummyTVShows = DataDummy.generateDummyTVShows();

    @Rule
    public ActivityScenarioRule<HomeActivity> activityRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void loadMovies(){
        delay2seconds();
        // allOf() is used to overcome ambiguous exception during testing that caused by espresso
        onView(allOf(withId(R.id.rv_items), isDisplayed()));
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
    }

    @Test
    public void loadMovieDetails(){
        delay2seconds();
        delay2seconds();
        delay2seconds();
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        delay2seconds();
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovies.get(0).getTitle())));
        onView(withId(R.id.text_year_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_year_name)).check(matches(withText("Year:")));
        onView(withId(R.id.text_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_year)).check(matches(withText(dummyMovies.get(0).getYear())));
        onView(withId(R.id.text_rating_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating_name)).check(matches(withText("Rating:")));
        onView(withId(R.id.text_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(String.format("%s / 10", dummyMovies.get(0).getRating()))));
        onView(withId(R.id.text_genre_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre_name)).check(matches(withText("Genre:")));
        onView(withId(R.id.text_genre_list)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre_list)).check(matches(withText(dummyMovies.get(0).getGenre())));
        onView(withId(R.id.text_stars_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_stars_name)).check(matches(withText("Stars:")));
        onView(withId(R.id.text_stars)).check(matches(isDisplayed()));
        onView(withId(R.id.text_stars)).check(matches(withText(dummyMovies.get(0).getStars())));
        onView(withId(R.id.text_storyline_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_storyline_name)).check(matches(withText("Storyline")));
        onView(withId(R.id.text_storyline)).check(matches(isDisplayed()));
        onView(withId(R.id.text_storyline)).check(matches(withText(dummyMovies.get(0).getStoryline())));
    }

    @Test
    public void loadTVShows(){
        delay2seconds();
        onView(withText("TV Shows")).perform(click());
        delay2seconds();
        onView(allOf(withId(R.id.rv_items), isDisplayed()));
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyTVShows.size()));
    }

    @Test
    public void loadTVShowDetails(){
        delay2seconds();
        onView(withText("TV Shows")).perform(click());
        delay2seconds();
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        delay2seconds();
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(dummyTVShows.get(0).getTitle())));
        onView(withId(R.id.text_year_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_year_name)).check(matches(withText("Year:")));
        onView(withId(R.id.text_year)).check(matches(isDisplayed()));
        onView(withId(R.id.text_year)).check(matches(withText(dummyTVShows.get(0).getYear())));
        onView(withId(R.id.text_rating_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating_name)).check(matches(withText("Rating:")));
        onView(withId(R.id.text_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(String.format("%s / 10", dummyTVShows.get(0).getRating()))));
        onView(withId(R.id.text_genre_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre_name)).check(matches(withText("Genre:")));
        onView(withId(R.id.text_genre_list)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre_list)).check(matches(withText(dummyTVShows.get(0).getGenre())));
        onView(withId(R.id.text_stars_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_stars_name)).check(matches(withText("Stars:")));
        onView(withId(R.id.text_stars)).check(matches(isDisplayed()));
        onView(withId(R.id.text_stars)).check(matches(withText(dummyTVShows.get(0).getStars())));
        onView(withId(R.id.text_storyline_name)).check(matches(isDisplayed()));
        onView(withId(R.id.text_storyline_name)).check(matches(withText("Storyline")));
        onView(withId(R.id.text_storyline)).check(matches(isDisplayed()));
        onView(withId(R.id.text_storyline)).check(matches(withText(dummyTVShows.get(0).getStoryline())));
    }


    private void delay2seconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}