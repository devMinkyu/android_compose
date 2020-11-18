package com.tag_hive.saathi.saathi.presentation.screen.main

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.tag_hive.saathi.saathi.R
import com.tag_hive.saathi.saathi.presentation.screen.main.module.*
import com.tag_hive.saathi.saathi.presentation.ui.white500

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: VectorAsset) {
    object Home : Screen("home", R.string.main_tab_home, Icons.Filled.Home)
    object Review : Screen("review", R.string.main_tab_review, Icons.Filled.Favorite)
    object Pocket : Screen("pocket", R.string.main_tab_pocket, Icons.Filled.Edit)
    object Report : Screen("report", R.string.main_tab_report, Icons.Filled.Favorite)
    object More : Screen("more", R.string.main_tab_more, Icons.Filled.Settings)
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { bottomNavigation(navController) },
    ) {
        MainScreenNavigationConfigurations(navController = navController)
    }
}

@Composable
private fun bottomNavigation(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        Screen.Home,
        Screen.Review,
        Screen.Pocket,
        Screen.Report,
        Screen.More,
    )
    BottomNavigation(
        backgroundColor = white500
    ) {
        val currentRoute = currentRoute(navController)
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

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}


@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            Home(navController = navController)
        }
        composable(Screen.Review.route) {
            Review(navController = navController)
        }
        composable(Screen.Pocket.route) {
            Pocket(navController = navController)
        }
        composable(Screen.Report.route) {
            Report(navController = navController)
        }
        composable(Screen.More.route) {
            More(navController = navController)
        }
    }
}
