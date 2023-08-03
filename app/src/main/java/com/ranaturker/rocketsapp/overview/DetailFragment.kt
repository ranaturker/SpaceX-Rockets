package com.ranaturker.rocketsapp.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.databinding.FragmentDetailBinding
import com.ranaturker.rocketsapp.databinding.FragmentListBinding
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
        arguments?.let{
            val data = DetailFragmentArgs.fromBundle(it).rocket
            showRocketDetails(data)
        }
    }

    private fun showRocketDetails(rocket:Rockets) = with(binding){

        // Bind the rocket data to UI elements
        name.text = rocket.name
        description.text = rocket.description
    }
}

