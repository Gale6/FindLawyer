package com.revature.findlawyer

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.revature.findlawyer.ui.Screen_Histories
import com.revature.findlawyer.ui.Screen_ScheduleNewAppointment
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.ui.ui.Screen_AppointmentMade
import com.revature.findlawyer.viewmodel.AppointmentViewModel

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = AppointmentViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Screen_ScheduleNewAppointment(
//                        firstName = "dfsfa",
//                        lastName = "dafadf",
//                        typeOfPractice = "dfasdf",
//                        rating = 4.5f,
//                        image = "dfadfa",
//                        numCases = 45)
                    //Screen_CurrentAppointmentScreen(viewModel = viewModel)

                    //Screen_AppointmentMade()

                    Screen_Histories(viewModel = viewModel)



                }

            }
        }
    }
}
