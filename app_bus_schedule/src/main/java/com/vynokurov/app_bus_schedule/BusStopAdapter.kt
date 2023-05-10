package com.vynokurov.app_bus_schedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.db_main.entity.ScheduleEntity
import com.vynokurov.app_bus_schedule.databinding.BusStopItemBinding
import java.text.SimpleDateFormat
import java.util.*

class BusStopAdapter(private val onItemClick: (ScheduleEntity) -> Unit ) : ListAdapter<ScheduleEntity,
        BusStopAdapter.BusStopViewHolder>(DiffCallback) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusStopViewHolder {
        val viewHolder = BusStopViewHolder(
            BusStopItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClick(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BusStopViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<ScheduleEntity> () {
            override fun areItemsTheSame(oldItem: ScheduleEntity, newItem: ScheduleEntity) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ScheduleEntity, newItem: ScheduleEntity) = oldItem == newItem

        }
    }

    class BusStopViewHolder(private var binding: BusStopItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SimpleDateFormat")
        fun bind(scheduleEntity: ScheduleEntity) {
            binding.stopNameTextView.text = scheduleEntity.stopName
            binding.arrivalTimeTextView.text = SimpleDateFormat("h:mm a")
                .format(Date(scheduleEntity.arrivalTime.toLong() * 1000))
        }
    }

}