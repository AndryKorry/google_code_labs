package com.vynokurov.db_inventory_app.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vynokurov.db_inventory_app.entity.InventoryItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: InventoryItemEntity)

    @Update
    suspend fun updateItem(item: InventoryItemEntity)

    @Delete
    suspend fun deleteItem(item: InventoryItemEntity)

    @Query("SELECT * FROM inventoryItem WHERE id = :id")
    fun getItemById(id: Int): Flow<InventoryItemEntity>

    @Query(" SELECT * FROM inventoryItem ORDER BY name ASC")
    fun getAllItems(): Flow<List<InventoryItemEntity>>
}