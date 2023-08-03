package com.ranaturker.rocketsapp.overview

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
        imageViewRocket.load(rocket.flickrImages?.get(1))
        imageViewStatus.load(statusIcon)
    }

}

