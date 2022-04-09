package com.revature.findlawyer.ui

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.compose.rememberImagePainter

import com.revature.findlawyer.R
import com.revature.findlawyer.viewmodel.*

@Composable
fun Screen_CustomerProfile(navController:NavHostController, fetchCustomerViewModel: FetchProfileViewModel) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = { Text("Profile") })
        },
        bottomBar = {
            BottNavBar(navController)
        }
    ) {
        fetchCustomerViewModel.fetchProfile()
        var userName = uname
        var userPass = upass
        var userAdd = uadd
        var userPro = upro
        val notification = rememberSaveable { (mutableStateOf("")) }
        //val reviewArray:ArrayList<Review> = ArrayList<Review>()
        if (notification.value.isNotEmpty()) {
            Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        }
        var str2 = "Chadwick Grant"
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .padding(15.dp),
                shape = CircleShape,
            ) {


                val imageUri = rememberSaveable { mutableStateOf("") }

                val painter = rememberAsyncImagePainter(
                    if (imageUri.value.isEmpty())
                        R.drawable.ic_user
                    else
                        imageUri.value
                )
                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetContent()
                ) { uri: Uri? ->
                    uri?.let { imageUri.value = it.toString() }
                }
                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(100.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { launcher.launch("image/*") },
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            var str1 = "Amy Thompson"
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "Username: ${userName}",
                    //color = Color.Black
                )
            }
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "Password: ${userPass}",
                    //color = Color.Black
                )
            }
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "${userName} Address:",
                    //color = Color.Black
                )
            }
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "$userAdd",
                    //color = Color.Black
                )
            }
            var str3 = "Cary Stephens"
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                elevation = 5.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = str1,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        //text = location,
                        text = "The best in the business",
                        style = MaterialTheme.typography.body2,
                    )/*
            Text(
                text = comments,
                style = MaterialTheme.typography.body1,
            )*/
                }
            }
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                elevation = 5.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = str2,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        //text = location,
                        text = "Great experience, good customer service",
                        style = MaterialTheme.typography.body2,
                    )/*
            Text(
                text = comments,
                style = MaterialTheme.typography.body1,
            )*/
                }
            }
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                elevation = 5.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = str3,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                    )
                    Text(
                        //text = location,
                        text = "Really helped me out of a tight spot",
                        style = MaterialTheme.typography.body2,
                    )/*
            Text(
                text = comments,
                style = MaterialTheme.typography.body1,
            )*/
                }
            }
        }

    }
}


//@Preview
//@Composable
//fun testCustomerProfile() {
//    Screen_CustomerProfile(navController = rememberNavController(), viewModel = FetchProfileViewModel())
//}