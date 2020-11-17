package com.example.mycompose.presentation.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.mycompose.presentation.screen.main.MainScreen
import com.example.mycompose.presentation.ui.MyComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MyApp(content: @Composable () -> Unit) {
    MyComposeTheme {
        content()
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MainScreen()
    }
}