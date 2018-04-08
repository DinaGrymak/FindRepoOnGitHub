package com.example.dina.findrepo.Screens

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiSelector
import com.example.dina.findrepo.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.junit.Assert

/**
 * Created by dina on 4/7/18.
 */
class SearchResultScreen: BaseScreen() {

    val repoResult = uiDevice.findObject(UiSelector().resourceId("com.example.dina.findrepo:id/repoListView"))
    val link = uiDevice.findObject(UiSelector().resourceId("android:id/content"))

    init {
        Assert.assertTrue("RepoListView isn't displayed", repoResult.waitForExists(3000))
    }

fun clickOnLink(index: Int) {
    val link = onData(anything()).inAdapterView(withId(R.id.repoListView))
    link.atPosition(index).perform(click())
}

//    init {
//        Assert.assertTrue("Link wasn't open", link.waitForExists(3000))
//    }

}