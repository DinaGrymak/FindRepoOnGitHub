package com.example.dina.findrepo

import android.app.Instrumentation
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.onData
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.dina.findrepo.Screens.SearchScreen
import org.junit.Assert


/**adb devices
 *
 * Created by dina on 3/25/18.
 */
@RunWith(AndroidJUnit4::class)
class AcceptanceTest {
    protected lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

        @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun searchRepo() {

        val search = SearchScreen()
        val repo_name = "Eggs"
        search.typeTextIntoRepoField(repo_name)
        search.clickOnSearchRepoBtn()
        Thread.sleep(2000)

        val repoResult = uiDevice.findObject(UiSelector().resourceId("com.example.dina.findrepo:id/repoListView"))
        Assert.assertTrue("RepoListView isn't displayed", repoResult.waitForExists(3000))
                //onData(allOf(withId(R.id.repoListView), 0)).check(matches(hasDescendant(withText("egg")))))

//        onData(allOf(withId(R.id.repoListView))).atPosition(2)
//               .check(matches(withText(containsString("eggs"))))
//        onData(anything()).inAdapterView(allOf(withId(R.id.repoListView)))
//                .atPosition(0).perform(click())

    }
}