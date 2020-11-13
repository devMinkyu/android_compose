package com.example.mycompose.presentaion.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.TextUnit
import androidx.ui.tooling.preview.Preview
import com.example.mycompose.presentaion.ui.MyComposeTheme
import com.example.mycompose.presentaion.ui.purple200

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            main()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun main() {
    MyComposeTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
                topBar = {
                    TopAppBar(title = { Text("TopAppBar") }, backgroundColor = purple200)
                },
                bodyContent = {
                    Column() {
                        Greeting("Android")
                        Greeting()
                    }
                }
        )
    }
}

@Composable
fun Greeting(name: String = "Greeting") {
    Text(text = "Hello $name!", fontSize = TextUnit.Companion.Sp(10))
}