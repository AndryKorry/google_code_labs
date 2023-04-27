package com.vynokurov.app_inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vynokurov.db_inventory_app.dao.InventoryItemDao

class InventoryViewModelFactory(private val inventoryItemDao: InventoryItemDao): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(inventoryItemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}