package com.vynokurov.db_inventory_app.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventoryItem")
data class InventoryItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val itemName: String,
    @ColumnInfo(name = "price") val itemPrice: Double,
    @ColumnInfo(name = "quantity") val quantityInStock: Int
)
