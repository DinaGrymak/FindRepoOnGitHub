package com.example.dina.findrepo

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.util.Log
import org.junit.Before

/**
 * Created by dina on 4/7/18.
 */
open class BaseTest() {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Before
    fun setUp() {
        clearAppData()
        launchApp()
    }

    fun executeShellCommand(command: String) {
        val stdOut = uiDevice.executeShellCommand(command)
        Log.i("Test", command + ": " + stdOut)
    }

    fun clearAppData() = executeShellCommand("pm clear " + "com.example.dina.findrepo")
    fun killApp() = executeShellCommand("am force-stop " + "com.example.dina.findrepo")
    fun launchApp() = executeShellCommand("am start -n " + "com.example.dina.findrepo")
}