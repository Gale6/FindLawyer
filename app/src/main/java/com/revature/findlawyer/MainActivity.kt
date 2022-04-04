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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.ui.Screen_Histories
import com.revature.findlawyer.ui.Screen_ScheduleNewAppointment
import com.revature.findlawyer.ui.lawyersearch.Screen_LawyerSearch
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.AppointmentViewModel
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val appointmentViewModel = AppointmentViewModel()
        val fetchLawyersViewModel=FetchLawyersViewModel()

        super.onCreate(savedInstanceState)
        setContent {
            var navController: NavHostController
            FindLawyerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()

                    NavHostGraph(navController,appointmentViewModel,fetchLawyersViewModel)

                }
            }
        }
    }
}
