package com.example.dina.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

import android.support.design.widget.Snackbar
import android.support.test.espresso.idling.CountingIdlingResource
import com.example.dina.findrepo.util.EspressoIdlingResource
import io.fabric.sdk.android.services.network.UrlUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    protected val espressoTestIdlingResource: CountingIdlingResource = CountingIdlingResource("Network_Call")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fabric.with(this, Crashlytics())


        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val userRepoEditText = findViewById<EditText>(R.id.userRepoEditText)

        val button = findViewById<Button>(R.id.searchButton)
        button.setOnClickListener {

            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("searchTerm", searchEditText.text.toString())
            startActivity(intent)
        }

        val viewRepoButton = findViewById<Button>(R.id.userRepoButton)
        viewRepoButton.setOnClickListener {
            val intent = Intent(this, SearchResultActivity::class.java)
            intent.putExtra("username", userRepoEditText.text.toString())
            startActivity(intent)
        }
    }
}
