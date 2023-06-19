package com.example.perfumetest6.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perfumetest6.Graph
import com.example.perfumetest6.data.room.models.InventoryItem
import com.example.perfumetest6.ui.Category
import com.example.perfumetest6.ui.repository.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class InventoryViewModel(
    private val repository: Repository = Graph.repository
): ViewModel() {
    var state by mutableStateOf(InventoryState())
        private set
    private fun getItems(){
        viewModelScope.launch {
            repository.getAllInventoryItems.collectLatest {
                state = state.copy(
                    items = it
                )
            }
        }
    }
    fun deleteItem(item: InventoryItem){
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun onCategoryChange(category: Category){
        state = state.copy(category = category)
        filterBy(category.id)
    }

    fun onItemCheckedChange(item: InventoryItem, isChecked:Boolean){
        viewModelScope.launch{
            repository.updateItem(
                item = item.copy(isChecked = isChecked)
            )
        }
    }

    private fun filterBy(inventoryId:Int){
        if(inventoryId!=10001){
            viewModelScope.launch {
                repository.getInventoryItem( inventoryId ).collectLatest{
                    val itt = listOf<InventoryItem>(it)
                    state = state.copy(items = itt)
                }
            }
        } else {
            getItems()
        }
    }
}

data class InventoryState(
    val items:List<InventoryItem> = emptyList(),
    val category: Category = Category(),
    val itemChecked:Boolean = false
)