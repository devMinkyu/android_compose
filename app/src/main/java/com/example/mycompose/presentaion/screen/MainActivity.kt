package com.example.mycompose.presentaion.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.example.mycompose.presentaion.screen.common.Screen
import com.example.mycompose.presentaion.ui.MyComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Home")
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()
    MyComposeTheme {
        Scaffold(
            bottomBar = { bottomNavigation(navController) }
        ) {
            NavHost(navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { Home(navController) }
                composable(Screen.Review.route) { Review(navController) }
                composable(Screen.Pocket.route) { Pocket(navController) }
                composable(Screen.Report.route) { Report(navController) }
                composable(Screen.More.route) { More(navController) }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Text(text = "Home")
}

@Composable
fun Review(navController: NavController) {
    Text(text = "Review")
}

@Composable
fun Pocket(navController: NavController) {
    Text(text = "Pocket")
}

@Composable
fun Report(navController: NavController) {
    Text(text = "Report")
}

@Composable
fun More(navController: NavController) {
    Text(text = "Home")
}

@Composable
fun bottomNavigation(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        Screen.Home,
        Screen.Review,
        Screen.Pocket,
        Screen.Report,
        Screen.More,
    )
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.arguments?.getString(KEY_ROUTE)

        for (screen in items) {
            BottomNavigationItem(
                icon = { Icon(screen.icon) },
                label = { Text(stringResource(screen.resourceId)) },
                selected = currentRoute == screen.route,
                onClick = {
                    // This is the equivalent to popUpTo the start destination
                    navController.popBackStack(navController.graph.startDestination, false)

                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    Text(text = "122")
}