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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * MainAcitivtyTest
 *
 * Espresso Tests
 */

@RunWith(AndroidJUnit4.class)
public class MainAcitivtyTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void buttonBadExample(){
        ViewInteraction buttonInteraction = onView(withId(R.id.button_bad_example));

        buttonInteraction.check(
                matches(withText(R.string.bad_examples)));

        buttonInteraction.perform(click());


        onView(withId(R.id.text_view_clickable)).check(matches(withText(R.string.more_options)));
    }
}
