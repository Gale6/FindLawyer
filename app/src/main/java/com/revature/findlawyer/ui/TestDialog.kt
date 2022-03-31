package com.revature.findlawyer.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SimpleAlertDialog() {

    val openDialog = remember { mutableStateOf(true)  }
    if(openDialog.value){
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {


                    openDialog.value = false
                })
                { Text(text = "Schedule") }
            },
            dismissButton = {
                TextButton(onClick = {openDialog.value = false})
                { Text(text = "Cancel") }
            },
            title = { Text(text = "Please schedule a time") },
            text = {

            }
        )
    }
}

