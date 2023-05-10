package com.vynokurov.app_mars.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.app_mars.databinding.GridViewItemBinding
import com.vynokurov.app_mars.domain.MarsPhotoDomainModel

class PhotoGridAdapter : ListAdapter<MarsPhotoDomainModel, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    class MarsPhotoViewHolder(private var binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(marsPhoto: MarsPhotoDomainModel) {
            binding.photo = marsPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhotoDomainModel>() {

        override fun areItemsTheSame(oldItem: MarsPhotoDomainModel, newItem: MarsPhotoDomainModel)
        = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MarsPhotoDomainModel, newItem: MarsPhotoDomainModel)
        = oldItem.imageSource == newItem.imageSource
    }

}