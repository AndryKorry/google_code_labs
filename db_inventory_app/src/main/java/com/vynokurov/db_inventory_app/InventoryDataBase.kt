package com.vynokurov.db_inventory_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vynokurov.db_inventory_app.dao.InventoryItemDao
import com.vynokurov.db_inventory_app.entity.InventoryItemEntity

@Database(entities = [InventoryItemEntity::class], version = 1, exportSchema = false)
abstract class InventoryDataBase : RoomDatabase() {

    abstract fun inventoryItemDao(): InventoryItemDao

    companion object {

        @Volatile
        private var INSTANCE: InventoryDataBase? = null

        fun getDatabase(context: Context): InventoryDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDataBase::class.java,
                    "inventory_app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                return instance
            }
        }

    }
}