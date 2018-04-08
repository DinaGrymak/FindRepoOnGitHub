package com.example.dina.findrepo.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice

/**
 * Created by dina on 4/6/18.
 */
open class BaseScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

}