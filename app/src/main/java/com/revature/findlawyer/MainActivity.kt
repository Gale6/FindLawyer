package com.revature.findlawyer

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.revature.findlawyer.ui.Screen_CurrentAppointmentScreen
import com.revature.findlawyer.ui.Screen_ScheduleNewAppointment

import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.ui.theme.SimpleAlertDialog
import com.revature.findlawyer.ui.theme.test
import com.revature.findlawyer.viewmodel.FetchAppointmentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = FetchAppointmentViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {

                test()

                //SimpleAlertDialog()
                //Screen_ScheduleNewAppointment()
                //Screen_CurrentAppointmentScreen(viewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FindLawyerTheme {

    }
}