package com.example.dina.findrepo

import android.support.test.espresso.Espresso.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.dina.findrepo.Screens.SearchResultScreen
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

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun searchUser() {
        val search = SearchScreen()
        search.typeTextIntoField(search.userField, "DinaGrymak")
        search.clickViewBtn()
        search.waitForExist()
        pressBack()
        search.cleanUserField()
        search.checkUserHint()

        val user = "bay-qa"
        search.typeTextIntoField(search.userField, user)
        search.clickViewBtn()
        search.waitForExist()

        val searchResult = SearchResultScreen()
        Assert.assertTrue("List of users is not displayed", searchResult.repoResult.waitForExists(globalTimeOut))
        searchResult.clickOnLink(3)
        val url = searchResult.textfromUrl()
        Assert.assertTrue("Opened url contains exact user name", url.contains(user))
    }

    @Test
    fun searchRepo() {
        val search = SearchScreen()
        search.checkRepoHint()
        val repo = "UltimateAndroid"
        search.typeTextIntoField(search.repoField, repo)
        search.clickSearchBtn()
        search.waitForExist()

        val searchresult = SearchResultScreen()
        searchresult.clickOnLink(5)
        searchresult.checkUrlExist()
    }

    @Test
    fun userNotFound() {
        val search = SearchScreen()
        search.cleanUserField()
        search.clickViewBtn()
        search.waitForExist()
        search.snackBar.exists()
    }
}