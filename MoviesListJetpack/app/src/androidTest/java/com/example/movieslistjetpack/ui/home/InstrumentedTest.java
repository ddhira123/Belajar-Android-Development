package com.example.movieslistjetpack.ui.home;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.example.movieslistjetpack.R;
import com.example.movieslistjetpack.data.source.local.entity.MovieEntity;
import com.example.movieslistjetpack.data.source.local.entity.TVShowEntity;
import com.example.movieslistjetpack.ui.SplashScreenActivity;
import com.example.movieslistjetpack.utils.DataDummy;
import com.example.movieslistjetpack.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class InstrumentedTest {

    private final List<MovieEntity> dummyMovies = DataDummy.generateDummyMovies();
    private final List<TVShowEntity> dummyTVShows = DataDummy.generateDummyTVShows();

    @Before
    public void setup() {
        ActivityScenario.launch(SplashScreenActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies(){
        // allOf() is used to overcome ambiguous exception during testing that caused by espresso
        onView(allOf(withId(R.id.rv_items), isDisplayed()));
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
    }

    @Test
    public void loadMovieDetails(){
        onView(allOf(withId(R.id.rv_items), isDisplayed()));
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
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
        onView(withId(R.id.home)).check(matches(isDisplayed()));
        onView(withText("TV Shows")).perform(click());
        onView(allOf(withId(R.id.rv_items), isDisplayed()));
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.scrollToPosition(dummyTVShows.size()));
    }

    @Test
    public void loadTVShowDetails(){
        onView(withText("TV Shows")).check(matches(isDisplayed()));
        onView(withText("TV Shows")).perform(click());
        onView(allOf(withId(R.id.rv_items), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
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
}