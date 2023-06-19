package com.example.perfumetest6.screens

import android.icu.text.SimpleDateFormat
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.perfumetest6.bottomnav.BottomNavigationScreen
import com.example.perfumetest6.bottomnav.Screens
import com.example.perfumetest6.data.room.InventoryItems
import com.example.perfumetest6.data.room.models.InventoryItem
import com.example.perfumetest6.ui.Category
import com.example.perfumetest6.ui.Utils
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(
//    onNavigate:(Int) -> Unit

) {
    val inventoryViewModel = viewModel(modelClass = InventoryViewModel::class.java)
    val inventoryState = inventoryViewModel.state
    val listItems = listOf(
        Screens.Inventory,
        Screens.Formulas,
    )
    val navController = rememberNavController()
    Scaffold(
//        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            BottomNavigationScreen(
                navController = navController,
                items = listItems
            )
        },
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
        
    } ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
//            Modifier.paint(painterResource(id = R.drawable.ic_allie), contentScale = ContentScale.FillHeight)
        ){
            item {
                LazyRow {
                    items(Utils.category) { category: Category ->
                        CategoryItem(
                            iconRes = category.resId,
                            title = category.title,
                            selected = category == inventoryState.category
                        ) {
                            inventoryViewModel.onCategoryChange(category)
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
            }
            items(inventoryState.items){

            }
        }
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
                else MaterialTheme.colorScheme.surface
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
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight(16)
            )
        }
    }
}

@Composable
fun InventoryItems(
    item:InventoryItems,
    isChecked:Boolean,
    onCheckedChange:(InventoryItem,Boolean)->Unit,
    onItemClick:() -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick.invoke()
            }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
        Column(modifier = Modifier.padding(8.dp)){
            Text(
                text=item.inventory.commonName,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.Companion.size(4.dp))
            Text(text=item.inventory.CAS)
            Spacer(modifier = Modifier.Companion.size(4.dp))

            CompositionLocalProvider(
                LocalContentColor provides LocalContentColor.current.copy(alpha = 0.4f)
            ) {
                Text(
                    text = formatDate(item.inventory.acquisitionDate),
                    style = MaterialTheme.typography.labelSmall
                )


                }

            }
}
        }
    }


fun formatDate(date: Date):String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)

//@Composable
//@Preview
//fun InventoryScreenPreview(){
//    InventoryScreen()
//}