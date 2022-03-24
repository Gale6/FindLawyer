package com.revature.findlawyer.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewUserLogin(){
    UserLogIn()
}

@Composable
fun UserLogIn(){

    Scaffold() {

        //top app bar
        //back arrow clickable
        //register text clickable

        //logo text image
        //log in text

        Canvas(modifier = Modifier.size(5.dp,5.dp)){
            //draw horizontal line or some other shape test
        }

        Card() {

            //text field (user name)
            //text field (password)
            //log in button
            //forgot password text clickable

        }

        Canvas(modifier = Modifier.size(5.dp,5.dp)){
            //draw horizontal line or some other shape test
        }



    }


}