package com.example.dina.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.espresso.UiController
import android.support.test.espresso.matcher.ViewMatchers.isRoot
import android.support.test.espresso.ViewAction
import android.view.View
import org.hamcrest.Matcher
import android.support.test.espresso.idling.CountingIdlingResource
import android.support.design.widget.Snackbar
import com.example.dina.findrepo.R.layout.activity_main
import android.os.Bundle
import com.example.dina.findrepo.R


/**
 * Created by dina on 4/6/18.
 */
open class BaseScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    fun waitFor(millis: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isRoot()
            }

            override fun getDescription(): String {
                return "Wait for $millis milliseconds."
            }

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadForAtLeast(millis)
            }
        }
    }
}

