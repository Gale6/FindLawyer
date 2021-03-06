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
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.ui.theme.Cormorantgaramond


//@Preview
//@Composable
//fun previewTest(){
//    MainOverllScreen ()
//}
@Composable
fun MainOverllScreen (navController: NavController){

    Scaffold(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/) {

        Image(painter = painterResource(id = R.drawable.searching), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)


        LogoMain()

        Column(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/.padding(4.dp),verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.End) {

            Text(text = "IN THE WEEDS? ADVOCATE CAN HELP. ",textAlign = TextAlign.Center, modifier = Modifier.padding(2.dp).offset(x=-20.dp,y=-55.dp).width(220.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.ExtraBold,fontSize = 25.sp )

            Button(onClick = { navController.navigate(DrawerScreens.MainUser.route) },modifier=Modifier.padding(4.dp).width(220.dp).offset(x=-18.dp,y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Continue", modifier = Modifier.padding(2.dp),color=Color.White)

            }
//            Button(onClick = { navController.navigate(DrawerScreens.MainLawyer.route) },modifier=Modifier.padding(4.dp).width(220.dp).offset(x=-18.dp,y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
//                Text(text = "Lawyer", modifier = Modifier.padding(2.dp),color=Color.White)
//
//            }

        }
        
    }

}