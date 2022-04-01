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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.ui.theme.NewScheduleAlertDialog
import com.revature.findlawyer.viewmodel.AppointmentViewModel


@Composable
fun Screen_CurrentAppointmentScreen(viewModel:AppointmentViewModel){

    val listState = rememberLazyListState()
    val selected = remember{ mutableStateOf("")}

    val openDialogState = remember { mutableStateOf(false) }
    val openCancelDialog = remember{ mutableStateOf(false)}

    Scaffold(modifier = Modifier.fillMaxSize()) {

        LazyColumn(state = listState){
            items(viewModel.result.value){
                    item: com.revature.findlawyer.data.network.Appointment -> AppointmentCard(
                targetName = item.targetName,
                time = item.time,
                openDialogState = openDialogState,
                viewModel = viewModel,
                selected = selected,
                openConfirmationDialog = openCancelDialog
            )
            }
        }
        NewScheduleAlertDialog(viewModel = viewModel,openDialogState,selected)
        CancelConfirmationDialog(openDialogState = openCancelDialog)
    }
}


@Composable
fun AppointmentCard(targetName:String,time:String,openDialogState:MutableState<Boolean>,viewModel: AppointmentViewModel,selected:MutableState<String>,openConfirmationDialog:MutableState<Boolean>){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
        .border(
            width = 1.dp,
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

            Column (verticalArrangement = Arrangement.Center){
                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(1.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                        viewModel.fetchAvailableAppointment()
                        openDialogState.value = true
                        viewModel.updateAppointment("lawyer1",targetName,time,selected.value)
                    }) {
                    Text(text = "reschedule")
                }

                Button(modifier = Modifier
                    .width(130.dp)
                    .padding(1.dp),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                        openConfirmationDialog.value = true
                        //todo
                    }) {
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
        Screen_CurrentAppointmentScreen(viewModel = AppointmentViewModel())
    }
}