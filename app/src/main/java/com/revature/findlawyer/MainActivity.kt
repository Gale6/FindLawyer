package com.revature.findlawyer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.revature.findlawyer.ui.Screen_CurrentAppointmentScreen
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.AppointmentViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = AppointmentViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SimpleAlertDialog(viewModel = viewModel, openDialogState = remember { mutableStateOf(true)  })
                    Screen_CurrentAppointmentScreen(viewModel = viewModel)
                }

            }
        }
    }
}
