package com.revature.findlawyer.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.R
import com.revature.findlawyer.viewmodel.AppointmentViewModel

@Composable
fun Screen_Histories(navController: NavHostController,viewModel: AppointmentViewModel){

    viewModel.fetchHistory()

    Scaffold (
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("History")})
        },
        bottomBar = {
        BottNavBar(navController)
    }){

        Image(painter = painterResource(id = R.drawable.searching), contentDescription = "",contentScale = ContentScale.FillBounds,alpha = .4f)


        LazyColumn(){

            items(viewModel.histories.value){
                HistoryCard(
                    firstName = it.firstName,
                    lastName = it.lastName,
                    typeOfPractice = it.typeOfPractice,
                    rating = it.rating,
                    image = it.img,
                    numCases = it.numCases,
                    time = it.time,
                    navController = navController
                )

            }


        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HistoryCard(navController: NavHostController,firstName:String,lastName:String,typeOfPractice:String,rating:Float,image:String,numCases:Int,time:String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { }//go to other composable
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {

            Image(
                painter = rememberImagePainter(image),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth()) {

                Text(
                    text = firstName+" "+lastName,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = typeOfPractice,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row() {
                    Text(
                        text = rating.toString(),
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Image(painter = painterResource(R.drawable.star3_ccexpress), contentDescription = null,
                        Modifier
                            .size(20.dp)
                            .padding(2.dp))

                    Text(
                        text = numCases.toString()+" cases",
                        style = MaterialTheme.typography.body2,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.absolutePadding(bottom = 4.dp, left = 28.dp)
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "last meeting: $time")
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxWidth() ){
                    Spacer(modifier = Modifier.width(0.dp))
                    Button(onClick = { navController.navigate(DrawerScreens.Screen_PostReview.route) }) {
                        Text(text = "Post review")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun pre(){

HistoryCard(navController = rememberNavController(), firstName = "testf",lastName = "testl",typeOfPractice = "testp",rating = 4.5f,image = "dsfa",numCases = 43, time = "3/14/2422  13:23")

}