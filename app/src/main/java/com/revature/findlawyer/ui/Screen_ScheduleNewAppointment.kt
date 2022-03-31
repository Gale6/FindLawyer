package com.revature.findlawyer.ui

import android.os.Build
import android.util.Log
import android.widget.NumberPicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Screen_ScheduleNewAppointment() {

    val current = LocalDateTime.now()
    Log.d("hih",current.toString())

    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")

    var result = current.format(formatter)

    Log.d("hih",result)

    var res = LocalDate.parse(result,formatter)

    Log.d("hih",res.toString())

    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = state,
        topBar = {
            TopAppBar(
                title = { Text(text = "AppBar") },
                navigationIcon = {
                    Icon(Icons.Rounded.Menu, contentDescription = "Localized description", modifier = Modifier.clickable {
                        scope.launch {
                            state.drawerState.open()
                        }
                    })
                }
            )
        },
        drawerContent = {
            Text(text = "Drawer")
        }
    ) {
        // Scaffold body
    }



}