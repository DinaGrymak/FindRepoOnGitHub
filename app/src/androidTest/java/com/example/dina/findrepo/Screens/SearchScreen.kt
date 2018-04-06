package com.example.dina.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiDevice
import com.example.dina.findrepo.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Before

/**
 * Created by dina on 3/31/18.
 */

class SearchScreen {
    protected lateinit var uiDevice: UiDevice
    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }


    val searchRepoBtn = onView(withId(R.id.searchButton))
    val searchUserBtn = onView(withId(R.id.userRepoButton))
    val searchRepoField = onView((withId(R.id.searchEditText)))
    val searchUserField = onView(withId(R.id.userRepoEditText))

    fun clickOnSearchRepoBtn() = searchRepoBtn.perform(click())

    fun clickOnSearchUserBtn() = searchUserBtn.perform(click())

    fun typeTextIntoRepoField(repo_name : String) = searchRepoField.perform(typeText(repo_name))
    fun typeTextIntoUserField(user_name : String) = searchUserField.perform(typeText(user_name))






}