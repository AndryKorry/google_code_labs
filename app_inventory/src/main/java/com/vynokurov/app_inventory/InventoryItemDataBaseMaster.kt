package com.vynokurov.app_inventory

import android.content.Context
import com.vynokurov.db_inventory_app.InventoryDataBase

object InventoryItemDataBaseMaster {

    open fun getInventoryDb(context: Context): InventoryDataBase {
        val database: InventoryDataBase by lazy { InventoryDataBase.getDatabase(context) }
        return database
    }
}