package com.revature.findlawyer.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchAppointmentViewModel


@Composable
fun Screen_CurrentAppointmentScreen(viewModel:FetchAppointmentViewModel){

    Scaffold(modifier = Modifier.fillMaxSize()) {

        var listState = rememberLazyListState()

        Column {
            LazyColumn(state = listState){
                items(viewModel.result.value){
                        item: com.revature.findlawyer.data.network.Appointment -> AppointmentCard(
                    targetName = item.targetName,
                    time = item.time
                )
                }
            }
        }
    }
}


@Composable
fun AppointmentCard(targetName:String,time:String){

    Card(modifier = Modifier
        .fillMaxWidth()
        .border(
            width = 2.dp,
            color = Color.Black,
            shape = RectangleShape
        )
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Spacer(modifier = Modifier)

            Text(text = targetName)

            Text(text = time)

            Column {
                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(3.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "reschedule")
                }
                //Spacer(modifier = Modifier.height(3.dp))

                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(3.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "cancel")
                }
            }



        }
    }
}

@Preview
@Composable
fun CurrentAppointmentPreview() {
    FindLawyerTheme {
        Screen_CurrentAppointmentScreen(viewModel = FetchAppointmentViewModel())
    }
}