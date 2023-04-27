package com.vynokurov.app_inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vynokurov.db_inventory_app.dao.InventoryItemDao
import com.vynokurov.db_inventory_app.entity.InventoryItemEntity
import kotlinx.coroutines.launch

class InventoryViewModel(private val inventoryItemDao: InventoryItemDao) : ViewModel() {

    private fun insertItem(item: InventoryItemEntity) {
        viewModelScope.launch {
            inventoryItemDao.insert(item)
        }
    }

    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String): InventoryItemEntity {
        return InventoryItemEntity(itemName = itemName, itemPrice = itemPrice.toDouble(), quantityInStock = itemCount.toInt())
    }

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        insertItem(getNewItemEntry(itemName, itemPrice, itemCount))
    }
    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String) : Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }
}