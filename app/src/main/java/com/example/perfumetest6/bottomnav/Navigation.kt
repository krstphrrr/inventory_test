package com.example.perfumetest6.bottomnav

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.perfumetest6.R
import com.example.perfumetest6.screens.FormulaScreen
import com.example.perfumetest6.screens.InventoryScreen

sealed class Screens (
    val route: String,
    val title: String,
    @DrawableRes val icons: Int

){
    object Inventory: Screens(
        route = "inventory",
        title = "Inventory",
        icons = R.drawable.ic_inv_fill,
    )
    object Formulas: Screens(
        route = "formulas",
        title = "Formulas",
        icons = R.drawable.ic_formula,
    )
}

@Composable
fun BottomNavHost(
    navHostController: NavHostController,
){
NavHost(
    navController = navHostController,
    startDestination = Screens.Inventory.route
) {
    composable(route = Screens.Inventory.route){
        InventoryScreen()
    }
    composable(route = Screens.Formulas.route){
        FormulaScreen()
    }
}
}

@Composable
fun BottomNavigationScreen(navController: NavController, items:List<Screens>){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach{screens ->
            NavigationBarItem(
                selected = currentDestination?.route == screens.route,
                onClick = {
                    navController.navigate(screens.route){
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                icon = {Icon(painter = painterResource(id = screens.icons), contentDescription = null )},
                label = {Text(text = screens.title)}
            )

        }
        
    }
}