package com.example.perfumetest6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.perfumetest6.ui.theme.PerfumeTest6Theme
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset

val tst_white = Color(0xFFFBFDF8)
val tst_pink = Color(0xFFD6B0BF)
val tst_ochre = Color(0xFFC68F4C)
val tst_red = Color(0xFFC68F4C)
val tst_green = Color(0xFF2A6B74)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfumeTest6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

data class TabRowItem(
    val title: String,
//    val icon: ImageVector,
    val screen: @Composable () -> Unit,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(tst_ochre),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = ":(",
        )
//
//        TabRow(
//            selectedTabIndex = pagerState.currentPage,
//            indicator = { tabPositions: List<androidx.compose.material3.TabPosition> ->
//                TabRowDefaults.Indicator(
//
//                    modifier = Modifier,
//                    color = tst_white
//                )
//            }
//        ) {
//
//        }
    }
}



@Composable
fun TabScreen(
    text: String,
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "popo",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

val tabRowItem = listOf(
    TabRowItem(
        title = "Ingredients",
        screen = { TabScreen(text = "Ingredients")},
    ),
    TabRowItem(
        title = "Formulas",
        screen = { TabScreen(text = "Formulas")}
    )
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PerfumeTest6Theme {
        Greeting("pp")
    }
}