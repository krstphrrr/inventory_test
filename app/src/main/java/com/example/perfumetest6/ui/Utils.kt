package com.example.perfumetest6.ui

import androidx.annotation.DrawableRes
import com.example.perfumetest6.R

object Utils {
    val category = listOf(
        Category(title = "Woody", resId = R.drawable.ic_circle, id = 0),
        Category(title = "Floral", resId = R.drawable.ic_circle, id = 1),
        Category(title = "Fruity", resId = R.drawable.ic_circle, id = 2),
        Category(title = "Spicy", resId = R.drawable.ic_circle, id = 3),
        Category(title = "Aquatic", resId = R.drawable.ic_circle, id = 4),
        Category(title = "None", resId =R.drawable.ic_circle ,id = 10001)
    )
}

data class Category(
    @DrawableRes val resId: Int = -1,
    val title: String = "",
    val id: Int = -1,
)