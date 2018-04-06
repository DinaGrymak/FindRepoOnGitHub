package com.example.dina.findrepo.util

import android.support.test.espresso.IdlingResource
import com.example.dina.findrepo.MainActivity

/**
 * Created by dina on 4/1/18.
 */
    class EspressoIdlingResource {

    private val RESOURCE = "GLOBAL"

    private val mCountingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

    val idlingResource
        get() = mCountingIdlingResource

    fun increment() {
        mCountingIdlingResource.increment()
    }

    fun decrement() {
        mCountingIdlingResource.decrement()
    }

    fun getIdlingResource(): IdlingResource {
        return mCountingIdlingResource
    }
}