package com.revature.findlawyer.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revature.findlawyer.viewmodel.UserRegisterViewModel

@Composable
fun Registeruser(navController: NavController,userRegisterViewModel: UserRegisterViewModel)
{
    var username= rememberSaveable { mutableStateOf("")}
    var firstname= rememberSaveable { mutableStateOf("")}
    var lastname= rememberSaveable { mutableStateOf("")}
    var password= rememberSaveable { mutableStateOf("")}
    val context=LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Register")
        Spacer(modifier = Modifier.height(15.dp))
        Column {


            TextField(value = firstname.value, onValueChange = {
                firstname.value = it
            }, label = {
                Text(text = "First name")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = lastname.value, onValueChange = {
                lastname.value = it
            }, label = {
                Text(text = "Last name")
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
            Button(onClick = {
                userRegisterViewModel.uRegister(username.value,password.value,firstname.value,lastname = lastname.value)
                if(userRegisterViewModel.issuccessful()==true)
                {
                    Toast.makeText(context,"Register Successful",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(context,"Enter the empty fields",Toast.LENGTH_LONG).show()
                }
            })
            {
                Text(text = "Register")
            }
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
        Spacer(modifier = Modifier.height(15.dp))
        Column {


            TextField(value = firstname.value, onValueChange = {
                firstname.value = it
            }, label = {
                Text(text = "firstname")
            })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value = lastname.value, onValueChange = {
                lastname.value = it
            }, label = {
                Text(text = "lastname")
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
            Button(onClick = {  }) {
                Text(text = "Register")
            }
        }
    }
}