package com.revature.findlawyer.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.revature.findlawyer.viewmodel.AppointmentViewModel
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen_ScheduleNewAppointment(navController:NavHostController,appointmentViewModel: AppointmentViewModel, lawyersViewModel: FetchLawyersViewModel) {

    val selected = remember{ mutableStateOf("") }
    val openDialogState = remember { mutableStateOf(false) }

    val firstName = lawyersViewModel.clickedLawyer.value.firstName
    val lastName = lawyersViewModel.clickedLawyer.value.lastName
    val image = lawyersViewModel.clickedLawyer.value.img
    val typeOfPractice = lawyersViewModel.clickedLawyer.value.typeOfPractice
    val rating = lawyersViewModel.clickedLawyer.value.rating
    val numCases = lawyersViewModel.clickedLawyer.value.numOfCases



    Scaffold (topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.primary,
            title = {Text("New Appointment")})
    },){

        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                elevation = 5.dp,
                backgroundColor = MaterialTheme.colors.surface
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Image(
                        painter = rememberImagePainter(image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                    Column(Modifier.padding(8.dp)) {

                        Text(
                            text = "$firstName $lastName",
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
                        Row {
                            Text(
                                text = rating.toString(),
                                style = MaterialTheme.typography.body2,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Image(painter = painterResource(com.revature.findlawyer.R.drawable.star3_ccexpress), contentDescription = null,
                                Modifier
                                    .size(20.dp)
                                    .padding(2.dp))

                            Text(
                                text = "$numCases cases",
                                style = MaterialTheme.typography.body2,
                                fontStyle = FontStyle.Italic,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier.absolutePadding(bottom = 4.dp, left = 28.dp)
                            )

                        }

                    }

                }

            }

            Button(onClick = {
                appointmentViewModel.fetchAvailableAppointment()
                openDialogState.value = true
            }) {

                Text(text = "Make Appointment")

            }
        }
    }
    NewScheduleAlertDialog(navController,viewModel = appointmentViewModel,openDialogState,selected, firstName, lastName)

}