package com.example.perfumetest6.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.perfumetest6.data.room.converters.DateConverter
import com.example.perfumetest6.data.room.models.FormulaItem
import com.example.perfumetest6.data.room.models.FormulaList
import com.example.perfumetest6.data.room.models.InventoryItem

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [InventoryItem::class, FormulaList::class, FormulaItem::class],
    version = 1,
    exportSchema = false
)
abstract class InventoryDatabase: RoomDatabase() {
    abstract fun inventoryItemDao():InventoryItemDao
    abstract fun formulaDao():FormulaDao
    abstract fun formulaItemDao(): FormulaItemDao

    companion object{
//        thread safe db creation
        @Volatile
        var INSTANCE:InventoryDatabase? = null
        fun getDatabase(context: Context):InventoryDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    InventoryDatabase::class.java,
                    "inventory_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}