package com.vynokurov.app_inventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.vynokurov.db_main.dao.InventoryItemDao
import com.vynokurov.db_main.entity.InventoryItemEntity
import kotlinx.coroutines.launch

class InventoryViewModel(private val inventoryItemDao: InventoryItemDao) : ViewModel() {
    val allInventoryItems: LiveData<List<InventoryItemEntity>> = inventoryItemDao.getAllItems().asLiveData()

    private fun insertItem(item: InventoryItemEntity) {
        viewModelScope.launch {
            inventoryItemDao.insert(item)
        }
    }

    private fun getNewItemEntry(itemName: String, itemPrice: String, itemCount: String) = InventoryItemEntity(itemName =
    itemName, itemPrice = itemPrice.toDouble(), quantityInStock = itemCount.toInt())


    private fun updateItem(item: InventoryItemEntity) {
        viewModelScope.launch { inventoryItemDao.updateItem(item) }
    }

    private fun getUpdatedItemEntry(itemId: Int, itemName: String, itemPrice: String, itemCount: String) = InventoryItemEntity(
            id = itemId,
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt()
        )


    fun updateItem(itemId: Int, itemName: String, itemPrice: String, itemCount: String) {
        val updatedItem = getUpdatedItemEntry(itemId, itemName, itemPrice, itemCount)
        updateItem(updatedItem)
    }

    fun deleteItem(item: InventoryItemEntity) {
        viewModelScope.launch { inventoryItemDao.deleteItem(item) }
    }

    fun sellItem(item: InventoryItemEntity) {
        if (item.quantityInStock > 0) {
            // Decrease the quantity by 1
            val newItem = item.copy(quantityInStock = item.quantityInStock - 1)
            updateItem(newItem)
        }
    }

    fun isStockAvailable(item: InventoryItemEntity): Boolean {
        return (item.quantityInStock > 0)
    }

    fun retrieveItem(id: Int): LiveData<InventoryItemEntity> {
        return inventoryItemDao.getItemById(id).asLiveData()
    }

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        insertItem(getNewItemEntry(itemName, itemPrice, itemCount))
    }

    fun isEntryValid(itemName: String, itemPrice: String, itemCount: String): Boolean {
        if (itemName.isBlank() || itemPrice.isBlank() || itemCount.isBlank()) {
            return false
        }
        return true
    }
}