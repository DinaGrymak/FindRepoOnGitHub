package com.example.dina.findrepo

import android.app.Instrumentation
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.dina.findrepo.Screens.SearchResultScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.dina.findrepo.Screens.SearchScreen
import org.junit.Assert
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.web.assertion.WebViewAssertions.webMatches
import android.support.test.espresso.web.sugar.Web.onWebView
import android.support.test.espresso.web.webdriver.DriverAtoms.findElement
import android.support.test.espresso.web.webdriver.DriverAtoms.getText
import android.support.test.espresso.web.webdriver.Locator
import org.hamcrest.CoreMatchers.*


/**adb devices
 *
 * Created by dina on 3/25/18.
 */
@RunWith(AndroidJUnit4::class)
class AcceptanceTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    @Test
    fun searchUser() {
        val search = SearchScreen()
        search.typeTextIntoField(search.userField, "booorisss")
        search.clickOnUserBtn()
        Thread.sleep(2000)
        pressBack()
        search.cleanUserField()
        search.checkUserHint()
        search.typeTextIntoField(search.userField, "DinaGrymak")
        search.clickOnUserBtn()
        Thread.sleep(2000)
        val searchresult = SearchResultScreen()
        searchresult.clickOnLink(0)

    }


    @Test
    fun searchRepo() {
        val search = SearchScreen()
        search.checkRepoHint()
        search.typeTextIntoField(search.repoField, "eggs")
        search.clickOnRepoBtn()
        Thread.sleep(2000)

        val searchresult = SearchResultScreen()
        searchresult.clickOnLink(5)

    }
}