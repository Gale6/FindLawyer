package com.revature.findlawyer.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.data.network.Token
import com.revature.findlawyer.viewmodel.AppointmentViewModel


@Composable
fun CancelConfirmationDialog(navHostController: NavHostController,viewModel: AppointmentViewModel,openDialogState: MutableState<Boolean>){

    if(openDialogState.value) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {

                    viewModel.deleteAppointment("","","")
                    viewModel.fetchAppointments(Token("dfadfdfa"))
                    openDialogState.value = false
                    navHostController.navigate(DrawerScreens.Screen_AppointmentCanceled.route)
                })
                { Text(text = "Confirm") }
            },
            dismissButton = {
                TextButton(onClick = { openDialogState.value = false })
                { Text(text = "Cancel") }
            },
            title = { Text(text = "Cancel confirmation") },
            text = { Text(text = "Are you sure you want to cancel this appointment?") })
    }
}


