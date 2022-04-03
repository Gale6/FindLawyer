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
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.ui.Screen_Histories
import com.revature.findlawyer.ui.Screen_ScheduleNewAppointment
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.ui.ui.Screen_AppointmentMade
import com.revature.findlawyer.viewmodel.AppointmentViewModel

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        var appointmentViewModel = AppointmentViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                }
                var navController= rememberNavController()
                NavHostGraph(navController = navController)
            }
        }
    }
}
