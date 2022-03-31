package com.revature.findlawyer.ui

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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Registeruser()
{
    var username= rememberSaveable { mutableStateOf("")}
    var firstname= rememberSaveable { mutableStateOf("")}
    var lastname= rememberSaveable { mutableStateOf("")}
    var password= rememberSaveable { mutableStateOf("")}
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
            Button(onClick = {  }) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
fun Registerlawyer()
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