package com.example.perfumetest6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.perfumetest6.bottomnav.BottomNav
import com.example.perfumetest6.bottomnav.BottomNavHost
import com.example.perfumetest6.bottomnav.BottomNavigationScreen
import com.example.perfumetest6.bottomnav.Screens
import com.example.perfumetest6.ui.theme.PerfumeTest6Theme

val tst_white = Color(0xFFFBFDF8)
val tst_pink = Color(0xFFD6B0BF)
val tst_ochre = Color(0xFFC68F4C)
val tst_red = Color(0xFFC68F4C)
val tst_green = Color(0xFF2A6B74)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listItems = listOf(
                Screens.Inventory,
                Screens.Formulas,
            )
            val navController = rememberNavController()
            PerfumeTest6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val padding = 10.dp
                  Scaffold(
                      bottomBar = {
                          BottomNavigationScreen(
                              navController = navController,
                              items = listItems
                          )
                      },


                  ){ contentPadding->

                      BottomNavHost(
                          navHostController = navController,
                      )
                  }
//                    BottomNav()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
@Preview
fun BottomNavPreview() {
    BottomNav()
}