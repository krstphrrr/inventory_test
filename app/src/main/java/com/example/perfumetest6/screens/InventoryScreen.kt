package com.example.perfumetest6.screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(
//    onNavigate:(Int) -> Unit
) {
    val inventoryViewModel = viewModel(modelClass = InventoryViewModel::class.java)
    val inventoryState = inventoryViewModel.state
    Scaffold(
        Modifier.safeContentPadding(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
//                    onNavigate.invoke(-1)
                }
            ) {
                Icon(
                    imageVector =Icons.Default.Add ,
                    contentDescription = null
                )
            }
        
    } ) {
//        LazyColumn {
//            item {
//                LazyRow {
//                    items(Utils.category) { category: Category ->
//                        CategoryItem(
//                            iconRes = category.resId,
//                            title = category.title,
//                            selected = category == inventoryState.category
//                        ) {
//                            inventoryViewModel.onCategoryChange(category)
//                        }
//                        Spacer(modifier = Modifier.size(16.dp))
//                    }
//                }
//            }
//        }
    }
}

@Composable
fun CategoryItem(
    @DrawableRes iconRes:Int,
    title:String,
    selected:Boolean,
    onItemClick:() -> Unit
){
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp)
            .selectable(
                selected = selected,
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(),
                onClick = { onItemClick.invoke() }
            )
            .background(
                if (selected) MaterialTheme.colorScheme.primary.copy(.5f)
                else MaterialTheme.colorScheme.onSurface
            ),
        border = BorderStroke(
            1.dp,
            if(selected) MaterialTheme.colorScheme.primary.copy(.5f)
                else MaterialTheme.colorScheme.onSurface,
        ),
        shape = MaterialTheme.shapes.large

    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ){
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight(16)
            )
        }
    }
}

@Composable
@Preview
fun InventoryScreenPreview(){
    InventoryScreen()
}