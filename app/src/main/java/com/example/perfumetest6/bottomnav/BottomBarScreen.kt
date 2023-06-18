package com.example.perfumetest6.bottomnav

import com.example.perfumetest6.R

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
    ){
    object Inventory: BottomBarScreen(
        route = "inventory",
        title = "Inventory",
        icon = R.drawable.ic_inv_fill,
        icon_focused = R.drawable.ic_inv_fill_focused
    )
    object Formulas: BottomBarScreen(
        route = "formulas",
        title = "Formulas",
        icon = R.drawable.ic_formula,
        icon_focused = R.drawable.ic_formula_focused
    )
}