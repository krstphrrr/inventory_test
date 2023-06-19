package com.example.perfumetest6.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "inventory_list")
data class InventoryItem(
    @ColumnInfo(name = "inventory_item_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val commonName: String,
    val CAS: String,
    val category: String,
    val inventoryAmountG: Double,
    val cost: Double,
    val supplier: String,
    val acquisitionDate: Long,
    val itemDescription: String,
    val itemNotes: String,
    val isChecked: Boolean,
)

@Entity(tableName = "formula_list")
data class FormulaList(
    @ColumnInfo(name = "formula_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formulaName: String,
    val formulaNotes: String,
    val formulaCreationDate: Date,
    val formulaModifiedDate: Date,
)

@Entity(tableName = "formula_item_list")
data class FormulaItem(
    @ColumnInfo(name = "formula_item_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val formulaItemAmount: Double,
    val formulaCalculatedRatio: Double,
    val formulaIdFk: Int,
    val inventoryItemFk: Int,
    val formulaItemNotes: String,
    val formulaItemCreationDate: Date,
    val formulaItemIsChecked: Boolean
)