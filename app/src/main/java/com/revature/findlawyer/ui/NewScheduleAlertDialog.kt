package com.revature.findlawyer.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import com.revature.findlawyer.viewmodel.AppointmentViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.data.network.Token

@Composable
fun NewScheduleAlertDialog(viewModel: AppointmentViewModel,openDialogState:MutableState<Boolean>,selected:MutableState<String>,firstName:String, lastName:String) {

    if(openDialogState.value){
        AlertDialog(
            modifier = Modifier.fillMaxHeight(.8f),
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {

                    viewModel.newAppointment("client1",firstName+lastName, selected.value)
                    viewModel.fetchAppointments(Token("dfadfdfa"))
                    openDialogState.value = false
                })
                { Text(text = "Schedule") }
            },
            dismissButton = {
                TextButton(onClick = {openDialogState.value = false})
                { Text(text = "Cancel") }
            },
            title = { Text(text = "Please schedule a time") },
            text = {
                var listState = rememberLazyListState()
                LazyColumn(state = listState){

                    items(viewModel.listOfAvailableTime.value){
                        item ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            RadioButton(selected = selected.value == item, onClick = { selected.value = item }, colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Black,
                            ))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = item, modifier = Modifier.clickable(onClick = { selected.value = item }))
                        }
                    }
                }
            }
        )
    }
}

