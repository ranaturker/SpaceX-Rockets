package com.ranaturker.rocketsapp.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ranaturker.rocketsapp.R
import com.ranaturker.rocketsapp.network.Rockets

class RocketAdapter(
    private var rocketList: List<Rockets>,
    val listener: RecyclerViewEvent
) :
    RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

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
        private val costTextView: TextView = itemView.findViewById(R.id.costTextView)
        private val imageViewRocket: ImageFilterView = itemView.findViewById(R.id.imageViewRocket)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(rocketList[position])
                }
            }
        }

        fun bind(rocket: Rockets) {
            val cost = "$" + rocket.costPerLaunch?.toString()
            nameTextView.text = rocket.name
            costTextView.text = cost
            imageViewRocket.load(rocket.flickrImages?.get(0))
        }
    }

    interface RecyclerViewEvent {
        fun onItemClick(data: Rockets)
    }
}
