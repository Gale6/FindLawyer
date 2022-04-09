package com.revature.findlawyer.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.ui.theme.Cormorantgaramond
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.LawyerLoginViewModel
import com.revature.findlawyer.viewmodel.UserLoginViewModel
import kotlinx.coroutines.launch

////////////////////////////////////  LAWYER LOG-IN  /////////////////////////////////////////

//@Preview
//@Composable
//fun previewLawyerLogiIn(){
//    LawyerLogIn()
//}

@Composable
fun LawyerLogIn(navController: NavController,viewModel:LawyerLoginViewModel){
    var userName by rememberSaveable { mutableStateOf("")}
    var userPassword by rememberSaveable { mutableStateOf("")}


    Scaffold(modifier = Modifier.fillMaxSize()/*.border(2.dp,color= Color.Red)*/) {

        Image(painter = painterResource(id = R.drawable.sign), contentDescription = ""/*,contentScale = ContentScale.Fit*/,alpha = .4f,alignment = Alignment.TopCenter)


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

            Button(onClick = {
                if (viewModel.logincred.value){
                    viewModel.lLogin(userName,userPassword)
                    //navController.navigate(DrawerScreens.UserLogIn.route)
                }

                },modifier= Modifier
                .padding(4.dp)
                .width(330.dp)
                .offset(y = 15.dp)/*.border(1.dp,color= Color.Black)*/) {
                Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

            }
        }
    }
}


////////////////////////////////////  USER LOG-IN  /////////////////////////////////////////


//@Preview
//@Composable
//fun previewUserLogiIn(){
//    FindLawyerTheme {
//        UserLogIn()
//    }
//
//}

@OptIn(ExperimentalMaterialApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun UserLogIn(navController: NavController,viewModel:UserLoginViewModel){

    var context = LocalContext.current
    var userName by rememberSaveable { mutableStateOf("")}
    var userPassword by rememberSaveable { mutableStateOf("")}
    var username="JohnWick"
    var userpassword="ineedtosue"

    //val username ="JohnWick"
    //val password="ineedtosue"

    val keyboardController=LocalSoftwareKeyboardController.current
    var isPasswordVisible by remember{mutableStateOf(false)}

    Scaffold(modifier = Modifier.fillMaxSize()) {

        Surface(modifier = Modifier.fillMaxHeight()/*.border(2.dp,color= Color.Red)*/,color = MaterialTheme.colors.background) {

            Image(painter = painterResource(id = R.drawable.agreement), contentDescription = ""/*,contentScale = ContentScale.Fit*/,alpha = .4f,alignment = Alignment.TopCenter)


            Column(modifier = Modifier
                .fillMaxSize()/*.border(2.dp,color= Color.Red)*/
                .padding(4.dp),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {

                //Spacer(modifier = Modifier.height(8.dp))

                Text(text = "PATRONS",textAlign = TextAlign.Center, modifier = Modifier
                    .padding(2.dp)
                    .offset(y = -15.dp),color= Color.Black,fontFamily = Cormorantgaramond,fontWeight = FontWeight.Bold,fontSize = 25.sp )

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
                    modifier = Modifier.width(330.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
                    visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = { IconButton(onClick = {isPasswordVisible=!isPasswordVisible}) {
                        Icon(imageVector = if (isPasswordVisible)Icons.Default.LockOpen else Icons.Default.Lock, contentDescription = "Password Toggle" ) }
                    }
                )

                Button(onClick = {
                    if (username.equals(userName)&&userpassword.equals(userPassword)){
                        viewModel.uLogin(userName,userPassword)
                        Toast.makeText(context,"Log In Successful", Toast.LENGTH_LONG).show()
                        navController.navigate(DrawerScreens.Screen_LawyerSearch.route)

                    }else Toast.makeText(context,"Invalid Authentication", Toast.LENGTH_LONG).show()



//                    if (viewModel.logincred.value){
//                        viewModel.uLogin(userName,userPassword)
//                        Toast.makeText(context,"Log In Successful", Toast.LENGTH_LONG).show()
//                        navController.navigate(DrawerScreens.Screen_LawyerSearch.route)
//                    }




                    }
                    ,modifier= Modifier
                        .padding(4.dp)
                        .width(330.dp)
                        .offset(y = 15.dp)/*.border(1.dp,color= Color.Black)*/) {
                    Text(text = "Log In", modifier = Modifier.padding(2.dp),color= Color.White)

                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(),Arrangement.SpaceEvenly,Alignment.CenterVertically) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = true, onCheckedChange = {},modifier = Modifier.offset(x=-20.dp))
                        Text(text = "Remember Me", fontSize = 12.sp,modifier = Modifier.offset(x=-20.dp))
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Forgot Password?",fontSize = 12.sp,modifier = Modifier.offset(x=15.dp))
                    }

                }

            }
        }
    }
}
