package com.example.perfumetest6

import android.content.Context
import com.example.perfumetest6.data.room.InventoryDatabase
import com.example.perfumetest6.ui.repository.Repository

object Graph {

    lateinit var db:InventoryDatabase
        private set

    val repository by lazy {
        Repository(
            inventoryItemDao = db.inventoryItemDao(),
            formulaDao = db.formulaDao(),
            formulaItemDao = db.formulaItemDao()
        )
    }

    fun provide(context: Context){
        db = InventoryDatabase.getDatabase(context)
    }
}