package com.ranaturker.rocketsapp.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.network.Rockets

class RocketAdapter(private var rocketList: List<Rockets>) : RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rocket_item, parent, false)
        return RocketViewHolder(view)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val rocket = rocketList[position]
        holder.bind(rocket)
    }

    override fun getItemCount(): Int {
        return rocketList.size
    }

    fun updateData(newList: List<Rockets>) {
        rocketList = newList
        notifyDataSetChanged()
    }

    inner class RocketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(rocket: Rockets) {
            nameTextView.text = rocket.name
            descriptionTextView.text = rocket.description

            // itemView.setOnClickListener { ... }
        }
    }
}
