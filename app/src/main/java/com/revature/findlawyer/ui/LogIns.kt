package com.revature.findlawyer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.findlawyer.R
import com.revature.findlawyer.ui.theme.Cormorantgaramond

////////////////////////////////////  LAWYER LOG-IN  /////////////////////////////////////////

@Preview
@Composable
fun previewLawyerLogiIn(){
    LawyerLogIn()
}

@Composable
fun LawyerLogIn(){
    var userName by rememberSaveable { mutableStateOf("")}
    var userPassword by rememberSaveable { mutableStateOf("")}


    Surface(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/,color = MaterialTheme.colors.background) {
        //Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",modifier = Modifier.size(400.dp,400.dp).offset(y=200.dp))
        //Image(painter = painterResource(id = R.drawable.citypersp), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .3f)
        Image(painter = painterResource(id = R.drawable.sign), contentDescription = ""/*,contentScale = ContentScale.Fit*/,alpha = .4f,alignment = Alignment.TopCenter)

        //Logo()
        //LogoMain()

        Column(modifier = Modifier
            .fillMaxSize()/*.border(2.dp,color= Color.Red)*/
            .padding(4.dp),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "LAW PROFESSIONALS",textAlign = TextAlign.Center, modifier = Modifier
                .padding(2.dp)
                .offset(y = -55.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.Bold,fontSize = 25.sp )

            OutlinedTextField(
                value = userName,
                onValueChange = { userName=it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "User Name") },
                modifier = Modifier.width(330.dp),/*.offset(60.dp)*/

            )

            OutlinedTextField(
                value = userPassword,
                onValueChange = {userPassword=it},
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Password") },
                modifier = Modifier.width(330.dp)

            )

            Button(onClick = { /*TODO*/ },modifier= Modifier
                .padding(4.dp)
                .width(330.dp)
                .offset(y = 15.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

            }
        }
    }

}


////////////////////////////////////  USER LOG-IN  /////////////////////////////////////////


@Preview
@Composable
fun previewUserLogiIn(){
    UserLogIn()
}

@Composable
fun UserLogIn(){
    var userName by rememberSaveable { mutableStateOf("")}
    var userPassword by rememberSaveable { mutableStateOf("")}

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxHeight()/*.border(2.dp,color= Color.Red)*/,color = MaterialTheme.colors.background) {
            //Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",modifier = Modifier.size(400.dp,400.dp).offset(y=200.dp))
            //Image(painter = painterResource(id = R.drawable.citypersp), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .3f)
            Image(painter = painterResource(id = R.drawable.agreement), contentDescription = ""/*,contentScale = ContentScale.Fit*/,alpha = .4f,alignment = Alignment.TopCenter)

            //Logo()
            //LogoMain()

            Column(modifier = Modifier
                .fillMaxSize()/*.border(2.dp,color= Color.Red)*/
                .padding(4.dp),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "PATRONS",textAlign = TextAlign.Center, modifier = Modifier
                    .padding(2.dp)
                    .offset(y = -35.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.Bold,fontSize = 25.sp )

                OutlinedTextField(
                    value = userName,
                    onValueChange = {userName=it},
                    shape = RoundedCornerShape(3.dp),
                    label = { Text(text = "User Name") },
                    modifier = Modifier.width(330.dp)/*.offset(60.dp)*/

                )

                OutlinedTextField(
                    value = userPassword,
                    onValueChange = {userPassword=it},
                    shape = RoundedCornerShape(3.dp),
                    label = { Text(text = "Password") },
                    modifier = Modifier.width(330.dp)

                )

                Button(onClick = { /*TODO*/ },modifier= Modifier
                    .padding(4.dp)
                    .width(330.dp)
                    .offset(y = 15.dp)/*.border(1.dp,color= Color.Black)*/) {
                    Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

                }


            }


        }


    }

    AppBarBottom()


}
