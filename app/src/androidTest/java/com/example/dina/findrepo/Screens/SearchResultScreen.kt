package com.example.dina.findrepo.Screens

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiCollection
import android.support.test.uiautomator.UiSelector
import com.example.dina.findrepo.R
import com.example.dina.findrepo.globalTimeOut
import org.hamcrest.CoreMatchers.*
import org.junit.Assert

/**
 * Created by dina on 4/7/18.
 */
class SearchResultScreen : BaseScreen() {
    val repoResult = UiCollection(UiSelector().resourceId("com.example.dina.findrepo:id/repoListView"))
    val url = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))


    init {
        Assert.assertTrue("RepoListView is not displayed", repoResult.waitForExists(globalTimeOut))
    }

    fun clickOnLink(index: Int) {
        val link = onData(anything()).inAdapterView(withId(R.id.repoListView))
        link.atPosition(index).perform(click())
    }

    fun checkUrlExist() {
        Assert.assertTrue("GitHub page is not displayed", url.waitForExists(3000))
    }

    fun textfromUrl() = url.text

    fun checkListContainsRepo(index: Int, repo: String) {
        val resultItem = repoResult.getChildByInstance(UiSelector()
                .resourceId("com.example.dina.findrepo:id/repoTextView"), index).text
        Assert.assertTrue(resultItem.contains(repo))
    }
}