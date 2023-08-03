package com.ranaturker.rocketsapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.network.Rockets

class DetailFragment : AppCompatActivity() {

    companion object {
        const val EXTRA_ROCKET = "extra_rocket"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)

        // val rocket = intent.getParcelableExtra<Rockets>(EXTRA_ROCKET)
        // rocket?.let { showRocketDetails(it) }
    }

    private fun showRocketDetails(rocket: Rockets) {
        // UI
    }

}