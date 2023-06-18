package com.example.perfumetest6.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.perfumetest6.screens.FormulaScreen
import com.example.perfumetest6.screens.InventoryScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Inventory.route
    ){
        composable(route = BottomBarScreen.Inventory.route){
            InventoryScreen()
        }
        composable(route = BottomBarScreen.Formulas.route){
            FormulaScreen()
        }
    }
}