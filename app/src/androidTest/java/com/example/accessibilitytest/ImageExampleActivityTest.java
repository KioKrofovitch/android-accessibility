package com.example.accessibilitytest;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * ImageExampleActivityTest
 *
 * Espresso Tests
 */

@RunWith(AndroidJUnit4.class)
public class ImageExampleActivityTest {
    @Rule
    public ActivityTestRule<ImageExampleActivity> mActivityRule = new ActivityTestRule(ImageExampleActivity.class);

    @Test
    public void testPokeballContentDescription(){
        ViewInteraction pokeballInteraction = onView(withId(R.id.image_button_pokeball));

        pokeballInteraction.check(matches(withContentDescription(R.string.show_pokemon)));

        pokeballInteraction.perform(click());
        pokeballInteraction.check(matches(withContentDescription(R.string.hide_pokemon)));
    }
}
