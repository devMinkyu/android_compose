package com.example.mycompose.presentaion.screen.common

import androidx.annotation.StringRes
import com.example.mycompose.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.profile)
    object Review : Screen("review", R.string.friends_list)
    object Pocket : Screen("pocket", R.string.friends_list)
    object Report : Screen("report", R.string.friends_list)
    object More : Screen("more", R.string.friends_list)
}