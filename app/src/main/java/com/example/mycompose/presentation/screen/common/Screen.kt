package com.example.mycompose.presentation.screen.common

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.VectorAsset
import com.example.mycompose.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: VectorAsset) {
    object Home : Screen("home", R.string.main_tab_home, Icons.Filled.Home)
    object Review : Screen("review", R.string.main_tab_review, Icons.Filled.Favorite)
    object Pocket : Screen("pocket", R.string.main_tab_pocket, Icons.Filled.Edit)
    object Report : Screen("report", R.string.main_tab_report, Icons.Filled.Favorite)
    object More : Screen("more", R.string.main_tab_more, Icons.Filled.Settings)
}