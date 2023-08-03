package com.ranaturker.rocketsapp.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranaturker.rocketsapp.databinding.FragmentListBinding
import com.ranaturker.rocketsapp.network.Rockets

class ListFragment : Fragment(), RocketAdapter.RecyclerViewEvent {

    private lateinit var binding: FragmentListBinding
    private lateinit var rocketAdapter: RocketAdapter
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        // Fetch the rockets from the API
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        rocketAdapter = RocketAdapter(emptyList(), this@ListFragment) // Empty list to start with
        recyclerView.adapter = rocketAdapter

        // Observe the list of rockets from the view model
        viewModel.getRockets()
        viewModel.rockets.observe(viewLifecycleOwner, Observer { rockets ->
            if (rockets != null) {
                rocketAdapter.updateData(rockets)
            }
        })

    }

    override fun onItemClick(data: Rockets) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment2(data))
    }
}

