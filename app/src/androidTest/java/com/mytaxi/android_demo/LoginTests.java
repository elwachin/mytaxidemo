package com.mytaxi.android_demo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.mytaxi.android_demo.activities.MainActivity;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@LargeTest
public class LoginTests {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkUsername_isDisplayed() {
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
    }

    @Test
    public void checkPassword_isDisplayed() {
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLoginButton_isDisplayed() {
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
    }

    @Test
    public void login() {
        onView(withId(R.id.edt_username)).perform(typeText("whiteelephant261"), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText("video1"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

    }

    @Test
    public void searchByName() {

        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
        onView(withId(R.id.textSearch)).perform(typeText("sar"), closeSoftKeyboard());
        onView(withText("Sarah Friedrich")).check(matches(isDisplayed()));

        onView(withText("Sarah Friedrich")).perform(click());

    }

    @Test
    public void logout() {
        onView(withId(R.id.toolbar)).perform(click());
        onView(withId(R.id.nav_username)).check(matches(withText("whiteelephant261")));
    }


}
