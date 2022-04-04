package com.revature.findlawyer.ui

import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.revature.findlawyer.R

@Composable
fun Screen_CustomerProfile() {

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
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
    Screen_CustomerProfile()
}