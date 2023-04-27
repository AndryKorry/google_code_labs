package com.vynokurov.app_inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.app_inventory.databinding.ItemListItemBinding
import com.vynokurov.db_inventory_app.entity.InventoryItemEntity
import com.vynokurov.db_inventory_app.entity.getFormattedPrice

class InventoryItemListAdapter(private val onItemClicked: (InventoryItemEntity) -> Unit) :
    ListAdapter<InventoryItemEntity, InventoryItemListAdapter.InventoryItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = InventoryItemViewHolder(
        ItemListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            )
        )
    )

    override fun onBindViewHolder(holder: InventoryItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    class InventoryItemViewHolder(private var binding: ItemListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InventoryItemEntity) {
            binding.apply {
                itemName.text = item.itemName
                itemPrice.text = item.getFormattedPrice()
                itemQuantity.text = item.quantityInStock.toString()
            }
        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<InventoryItemEntity>() {
            override fun areItemsTheSame(oldItem: InventoryItemEntity, newItem: InventoryItemEntity): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: InventoryItemEntity, newItem: InventoryItemEntity): Boolean {
                return oldItem.itemName == newItem.itemName
            }
        }
    }
}
