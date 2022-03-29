package com.revature.findlawyer.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.data.room_database.Appointment
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchAppointmentViewModel


@Composable
fun CurrentAppointmentScreen(viewModel:FetchAppointmentViewModel){

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


@Preview
@Composable
fun CurrentAppointmentPreview() {
    FindLawyerTheme {
        CurrentAppointmentScreen(viewModel = FetchAppointmentViewModel())
    }
}