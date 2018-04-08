package com.example.dina.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.dina.findrepo.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Assert
import org.junit.Before
import java.util.*

/**
 * Created by dina on 3/31/18.
 */

class SearchScreen: BaseScreen() {

    val repoBtn = onView(withId(R.id.searchButton))
    val userBtn = onView(withId(R.id.userRepoButton))
    val repoField: ViewInteraction = onView((withId(R.id.searchEditText)))
    val userField = onView(withId(R.id.userRepoEditText))
    val repoResult = uiDevice.findObject(UiSelector().resourceId("com.example.dina.findrepo:id/repoListView"))

    init {
        repoBtn
    }

    fun clickOnRepoBtn() = repoBtn.perform(click())
    fun clickOnUserBtn() = userBtn.perform(click())
    fun typeTextIntoField(fieldId: ViewInteraction, searchFor: String) = fieldId.perform(typeText(searchFor))
    fun cleanUserField() = userField.perform(clearText())
    fun cleanRepoField() = repoField.perform(clearText())
    fun checkUserHint() =  userField.check(matches(ViewMatchers.withHint("View User's Repo")))
    fun checkRepoHint() =  repoField.check(matches(ViewMatchers.withHint("Search for Repos")))





}