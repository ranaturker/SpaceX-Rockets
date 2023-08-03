package com.ranaturker.spacex.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.overview.ListViewModel
import com.ranaturker.rocketsapp.overview.RocketAdapter

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var rocketAdapter: RocketAdapter
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = rootView.findViewById(R.id.recyclerView)
        // Fetch the rockets from the API
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        rocketAdapter = RocketAdapter(emptyList()) // Empty list to start with
        recyclerView.adapter = rocketAdapter

        // Observe the list of rockets from the view model
        viewModel.getRockets()
        viewModel.rockets.observe(viewLifecycleOwner, Observer { rockets ->
            if (rockets != null) {
                rocketAdapter.updateData(rockets)
            }
        })

    }
}
