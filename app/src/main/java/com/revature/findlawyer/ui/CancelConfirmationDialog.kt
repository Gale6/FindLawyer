package com.revature.findlawyer.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState


@Composable
fun CancelConfirmationDialog(openDialogState: MutableState<Boolean>){

    if(openDialogState.value) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {
                    openDialogState.value = false
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


