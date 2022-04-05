package com.revature.findlawyer.ui

import android.net.Uri
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

@Composable
fun Screen_CustomerProfile(navController:NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
        },
        bottomBar = {
            BottNavBar(navController)
        }
    ){
        var userName: String = "BobbyTestUser"
        val notification = rememberSaveable { (mutableStateOf("")) }
        //val reviewArray:ArrayList<Review> = ArrayList<Review>()
        if (notification.value.isNotEmpty()) {
            Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        }
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

                val painter = rememberImagePainter(
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
//                    Image(
//                        painter = painter,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .wrapContentSize()
//                            .clickable { launcher.launch("image/*") },
//                        contentScale = ContentScale.Crop
//                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "${userName}",
                    //color = Color.Black
                )
            }
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "Password: ",
                    //color = Color.Black
                )
            }
            Surface(
                modifier = Modifier,
                //color = Color.White
            ) {
                Text(
                    text = "Other info",
                    //color = Color.Black
                )
            }
        }
    }

}

@Preview
@Composable
fun testCustomerProfile() {
    Screen_CustomerProfile(navController = rememberNavController())
}