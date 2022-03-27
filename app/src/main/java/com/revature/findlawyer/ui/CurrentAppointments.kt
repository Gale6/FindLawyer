package com.revature.findlawyer.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.data.room_database.Appointment
import com.revature.findlawyer.ui.theme.FindLawyerTheme


@Composable
fun CurrentAppointmentScreen(appointsList:List<Appointment>){
    Scaffold(modifier = Modifier.fillMaxSize()) {

        var listState = rememberLazyListState()

        LazyColumn(state = listState){
            items(appointsList){
                appointment: Appointment ->  AppointmentCard(
                targetName = appointment.targetName,
                time = appointment.time
            )
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }
    }
}
 



//data for test
val appointsList = listOf<Appointment>(
    Appointment("lawyer1","client1","3/5/22 14:00"),
    Appointment("lawyer1","client1","3/5/22 14:00"),
    Appointment("lawyer1","client1","3/5/22 14:00")
)

@Preview
@Composable
fun CurrentAppointmentPreview() {
    FindLawyerTheme {
        CurrentAppointmentScreen(appointsList)
    }
}