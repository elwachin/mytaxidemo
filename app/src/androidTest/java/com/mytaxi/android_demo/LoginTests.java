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

    //THIS SHOULD BE READ FROM AN EXTERNAL FILE LIKE A JSON
    private final String USERNAME = "whiteelephant261";
    private final String PASSWORD = "video1";

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
        onView(withId(R.id.edt_username)).perform(typeText(USERNAME), closeSoftKeyboard());
        onView(withId(R.id.edt_password)).perform(typeText(PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

    }



    @Test
    public void logout() {
        onView(withId(R.id.toolbar)).perform(click());
        onView(withId(R.id.nav_username)).check(matches(withText("whiteelephant261")));
    }


}
