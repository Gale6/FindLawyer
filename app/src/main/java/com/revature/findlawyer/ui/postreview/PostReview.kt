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



@Composable
fun postReviewScreen(name: String) {
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

    }
}