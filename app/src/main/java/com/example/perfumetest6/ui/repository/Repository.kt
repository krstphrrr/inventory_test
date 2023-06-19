package com.example.perfumetest6.ui.repository

import com.example.perfumetest6.data.room.FormulaDao
import com.example.perfumetest6.data.room.FormulaItemDao
import com.example.perfumetest6.data.room.InventoryItemDao
import com.example.perfumetest6.data.room.models.FormulaItem
import com.example.perfumetest6.data.room.models.FormulaList
import com.example.perfumetest6.data.room.models.InventoryItem
import kotlinx.coroutines.flow.Flow

class Repository (
    private val inventoryItemDao: InventoryItemDao,
    private val formulaDao: FormulaDao,
    private val formulaItemDao: FormulaItemDao
    ){

//    val getItemsWithFormulaAndInventory = FormulaItemDao.


//    complex queries
    fun getItemWithFormulaAndInventory(id:Int) = formulaItemDao
        .getItemWithFormulaAndInventoryFilteredById(id)

    fun getListWithFormulaAndInventory(id:Int) = formulaItemDao
        .getListWithFormulaAndInventoryFilteredById(id)

// formulas
    suspend fun insertFormula(formula: FormulaList){
        formulaDao.insert(formula)
    }
    //    inventory methods
    //     get all
    val getAllInventoryItems = inventoryItemDao.getAllInventoryItems()
    fun getInventoryItem(id: Int): Flow<InventoryItem> {
        return inventoryItemDao.getInventoryItem(id)
    }
    suspend fun insertItem(item: InventoryItem){
        inventoryItemDao.insert(item)
    }

    suspend fun deleteItem(item: InventoryItem){
        inventoryItemDao.delete(item)
    }

    suspend fun updateItem(item: InventoryItem){
        inventoryItemDao.update(item)
    }
//    formula items
    suspend fun insertFormulaItem(formulaItem: FormulaItem){
        formulaItemDao.insert(formulaItem)
    }

}