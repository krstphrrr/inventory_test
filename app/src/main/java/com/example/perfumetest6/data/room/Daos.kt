package com.example.perfumetest6.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.perfumetest6.data.room.models.FormulaItem
import com.example.perfumetest6.data.room.models.FormulaList
import com.example.perfumetest6.data.room.models.InventoryItem
import kotlinx.coroutines.flow.Flow


@Dao
interface InventoryItemDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: InventoryItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: InventoryItem)

    @Delete
    suspend fun delete(item: InventoryItem)

    @Query("SELECT * FROM inventory_list")
    fun getAllInventoryItems(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventory_list WHERE inventory_item_id =:inventoryItemId")
    fun getInventoryItem(inventoryItemId:Int):Flow<InventoryItem>
}

@Dao
interface FormulaDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(formulaList: FormulaList)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(formulaList: FormulaList)

    @Delete
    suspend fun delete(formulaList: FormulaList)

    @Query("SELECT * FROM formula_list")
    fun getAllFormulas(): Flow<List<FormulaList>>

    @Query("SELECT * FROM formula_list WHERE formula_id =:formulaId")
    fun getFormula(formulaId:Int):Flow<FormulaList>
}
@Dao
interface FormulaItemDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(formulaItem: FormulaItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(formulaItem: FormulaItem)

    @Delete
    suspend fun delete(formulaItem: FormulaItem)

    @Query("""
        SELECT * FROM formula_item_list AS FI INNER JOIN formula_list as FL 
        ON FI.formulaIdFk = FL.formula_id INNER JOIN inventory_list as IL 
        ON FI.inventoryItemFk = IL.inventory_item_id
    """)
    fun getItemWithFormulaAndInventory():Flow<List<ItemsWithFormulaAndInventory>>

    @Query("""
        SELECT * FROM formula_item_list AS FI INNER JOIN formula_list as FL 
        ON FI.formulaIdFk = FL.formula_id INNER JOIN inventory_list as IL 
        ON FI.inventoryItemFk = IL.inventory_item_id WHERE IL.inventory_item_id =:itemId
    """)
    fun getItemWithFormulaAndInventoryFilteredById(itemId:Int):Flow<List<ItemsWithFormulaAndInventory>>

    @Query("""
        SELECT * FROM formula_item_list AS FI INNER JOIN formula_list as FL 
        ON FI.formulaIdFk = FL.formula_id INNER JOIN inventory_list as IL 
        ON FI.inventoryItemFk = IL.inventory_item_id WHERE FL.formula_id =:listId
    """)
    fun getListWithFormulaAndInventoryFilteredById(listId:Int):Flow<List<ItemsWithFormulaAndInventory>>

    @Query("SELECT * FROM formula_item_list")
    fun getAllFormulas(): Flow<List<FormulaItem>>

    @Query("SELECT * FROM formula_item_list WHERE formula_item_id =:formulaItemId")
    fun getFormula(formulaItemId:Int):Flow<FormulaItem>
}

data class ItemsWithFormulaAndInventory(
    @Embedded val item: FormulaItem,
    @Embedded val formula: FormulaList,
    @Embedded val inventory: InventoryItem,
)