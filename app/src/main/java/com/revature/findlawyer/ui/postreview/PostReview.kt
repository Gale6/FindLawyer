package com.revature.findlawyer.ui.postreview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.revature.findlawyer.ui.postreview.ui.theme.FindLawyerTheme

class PostReview : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Post Review")})
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FindLawyerTheme {
        Greeting2("Android")
    }
}