package com.revature.findlawyer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.R


@Preview
@Composable
fun previewTest(){
    MainOverllScreen ()
}
@Composable
fun MainOverllScreen (){

    Scaffold(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/) {
        //Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",modifier = Modifier.size(400.dp,400.dp).offset(y=200.dp))
        Image(painter = painterResource(id = R.drawable.searching), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)

        //Logo()
        LogoMain()

        Column(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/.padding(4.dp),verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.End) {
            Button(onClick = { /*TODO*/ },modifier=Modifier.padding(4.dp).width(220.dp).offset(x=-18.dp,y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Patron", modifier = Modifier.padding(2.dp),color=Color.White)

            }
            Button(onClick = { /*TODO*/ },modifier=Modifier.padding(4.dp).width(220.dp).offset(x=-18.dp,y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Lawyer", modifier = Modifier.padding(2.dp),color=Color.White)

            }

        }


    }

}