package com.cs4540.sci_cafe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs4540.sci_cafe.databinding.EventItemViewBinding
import com.cs4540.sci_cafe.models.Event
import com.cs4540.sci_cafe.R
import com.cs4540.sci_cafe.utils.convertLongToDateString
import com.squareup.picasso.Picasso

class EventAdapter(private val items: List<Event>): RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private lateinit var binding: EventItemViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = EventItemViewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder constructor(val binding: EventItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        val eventTitle: TextView = binding.eventTitle
        val eventDate: TextView = binding.eventDate
        val eventImage: ImageView = binding.eventImage

        fun bind(item: Event) {
            eventTitle.text = item.name
            eventDate.text = convertLongToDateString(item.eventDate)
            Picasso.get().load(item.imageUrl).into(eventImage)
        }

    }
}