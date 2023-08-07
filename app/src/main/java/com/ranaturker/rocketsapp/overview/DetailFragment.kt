package com.ranaturker.rocketsapp.overview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.databinding.FragmentDetailBinding
import com.ranaturker.rocketsapp.network.Rockets

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var wikipediaUri: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        // Fetch the rockets from the API
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val data = DetailFragmentArgs.fromBundle(it).rocket
            showRocketDetails(data)
        }
        binding.wikipedia.setOnClickListener{
            if(wikipediaUri != null ){
                val uri= Uri.parse(wikipediaUri)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }

    private fun showRocketDetails(rocket: Rockets) = with(binding) {
        val isActive = rocket.active ?: false
        val statusIcon = if (isActive) {
            R.drawable.ic_active
        } else {
            R.drawable.ic_passive
        }
        // Bind the rocket data to UI elements
        name.text = rocket.name
        description.text = rocket.description
        company.text = rocket.company
        country.text = rocket.country
        successRate.text = rocket.successRatePct.toString()
        wikipediaUri = rocket.wikipedia
        imageViewRocket.load(rocket.flickrImages?.get(1))
        imageViewStatus.load(statusIcon)
    }

}

