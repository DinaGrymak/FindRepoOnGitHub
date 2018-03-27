package com.example.dina.findrepo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by dina on 3/25/18.
 */


@RunWith(AndroidJUnit4::class)
class AcceptanceTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun searchRepo() {

        val searchRepoField = Espresso.onView(withId(R.id.searchEditText))
        searchRepoField.perform(typeText("Eggs"))
        val searchRepoBtn = onView(withId(R.id.searchButton))
        searchRepoBtn.perform(click())
        Thread.sleep(2000)

        onData(anything()).inAdapterView(allOf(withId(R.id.repoListView)))
                .atPosition(0).perform(click())






    }

}