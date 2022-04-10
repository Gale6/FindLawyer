package com.revature.findlawyer.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.viewmodel.UserRegisterViewModel

@Composable
fun Registeruser(navController: NavController,userRegisterViewModel: UserRegisterViewModel)
{

    var username= rememberSaveable { mutableStateOf("")}
    var firstname= rememberSaveable { mutableStateOf("")}
    var lastname= rememberSaveable { mutableStateOf("")}
    var password= rememberSaveable { mutableStateOf("")}
    val context=LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.agreement),modifier = Modifier.size(width = 200.dp,height = 150.dp)
                ,contentDescription = ""/*,contentScale = ContentScale.Fit*/,alpha = .4f,alignment = Alignment.TopCenter)

        Text("Register",fontWeight = FontWeight.Bold,fontSize = 25.sp)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = firstname.value, onValueChange = {
            firstname.value = it
        }, label = {
            Text(text = "First name")
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = lastname.value, onValueChange = {
            lastname.value = it
        }, label = {
            Text(text = "Last name")
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = username.value, onValueChange = {
            username.value = it
        }, label = {
            Text(text = "Create Username")
        })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = password.value, onValueChange = {
            password.value = it
        }, label = {
            Text(text = "Create Password")
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            userRegisterViewModel.uRegister(
                username.value,
                password.value,
                firstname.value,
                lastname = lastname.value
            )
            if (userRegisterViewModel.issuccessful() == true) {
                if(password.value.length>=4&&username.value.length>=4) {
                    Toast.makeText(context, "Register Successful", Toast.LENGTH_LONG).show()
                    navController.navigate(DrawerScreens.UserLogIn.route)
                }
                else{
                    Toast.makeText(context, "The password and username need to be longer", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "Enter the empty fields", Toast.LENGTH_LONG).show()
            }
        },modifier = Modifier.fillMaxWidth().padding(horizontal=50.dp))
        {
            Text(text = "Signup")
        }
    }
}


@Composable
fun Registerlawyer(navController: NavController)
{
    var username= rememberSaveable { mutableStateOf("")}
    var firstname= rememberSaveable { mutableStateOf("")}
    var lastname= rememberSaveable { mutableStateOf("")}
    var password= rememberSaveable { mutableStateOf("")}
    var location= rememberSaveable { mutableStateOf("")}
    var types= rememberSaveable { mutableStateOf("")}
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Register")

        Column {

            Spacer(modifier = Modifier.height(500.dp))
            TextField(value = firstname.value, onValueChange = {
                firstname.value = it
            }, label = {
                Text(text = "First name")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = lastname.value, onValueChange = {
                lastname.value = it
            }, label = {
                Text(text = "Lastname")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = username.value, onValueChange = {
                username.value = it
            }, label = {
                Text(text = "username")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = password.value, onValueChange = {
                password.value = it
            }, label = {
                Text(text = "password")
            }, visualTransformation = PasswordVisualTransformation())
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = location.value, onValueChange = {
                location.value = it
            }, label = {
                Text(text = "location")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = types.value, onValueChange = {
                types.value = it
            }, label = {
                Text(text = "Types of cases")
            })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { }) {
                Text(text = "Register")
            }
        }
    }
}
