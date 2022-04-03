package com.revature.findlawyer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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


////////////////////////////////////  MAIN LAWYER  /////////////////////////////////////////

//@Preview
//@Composable
//fun previewMainLawyer(){
//    MainLawyer()
//}

@Composable
fun MainLawyer (navController: NavController){

    Surface(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/,color = MaterialTheme.colors.background) {

        Image(painter = painterResource(id = R.drawable.citypersp), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .3f)
        //Image(painter = painterResource(id = R.drawable.loginimg), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)

        Logo()


        Column(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/.padding(4.dp),verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "LOG IN OR REGISTER TO CONNECT WITH CLIENTS",textAlign = TextAlign.Center, modifier = Modifier.padding(2.dp).offset(y=-55.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.Bold,fontSize = 17.sp )

            Button(onClick = { navController.navigate(DrawerScreens.LawyerLogin.route) },modifier= Modifier.padding(4.dp).width(330.dp).offset(y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

            }
            Button(onClick = { /*navController.navigate(DrawerScreens."Lawyer Register Screen".route)*/ },modifier= Modifier.padding(4.dp).width(330.dp).offset(y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Register", modifier = Modifier.padding(2.dp),color= Color.White)

            }

        }


    }

}


////////////////////////////////////  MAIN USER  /////////////////////////////////////////


//@Preview
//@Composable
//fun previewMainUser(){
//    MainUser()
//}

@Composable
fun MainUser (navController: NavController){

    Surface(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/) {

        //Image(painter = painterResource(id = R.drawable.citypersp), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .3f)
        Image(painter = painterResource(id = R.drawable.loginimg), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)

        Logo()


        Column(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/.padding(4.dp),verticalArrangement = Arrangement.Bottom,horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "LOG IN OR REGISTER TO CONNECT WITH LAW PROFESSIONALS",textAlign = TextAlign.Center, modifier = Modifier.padding(2.dp).offset(y=-55.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.Bold,fontSize = 17.sp )

            Button(onClick = {navController.navigate(DrawerScreens.UserLogIn.route)},modifier= Modifier.padding(4.dp).width(330.dp).offset(y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

            }
            Button(onClick = {/*navController.navigate(DrawerScreens.UserLogIn.route)*/ },modifier= Modifier.padding(4.dp).width(330.dp).offset(y=-50.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Register", modifier = Modifier.padding(2.dp),color= Color.White)

            }

        }


    }

}