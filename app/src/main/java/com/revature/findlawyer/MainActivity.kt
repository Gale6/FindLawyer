package com.revature.findlawyer

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.ui.*
import com.revature.findlawyer.data.room_database.Appointment
import com.revature.findlawyer.ui.lawyersearch.Screen_LawyerSearch
import com.revature.findlawyer.ui.postreview.screen_postReview
//import com.revature.findlawyer.ui.CurrentAppointmentScreen
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchAppointmentViewModel
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel=FetchLawyersViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen_LawyerSearch(viewModel = viewModel)
                }

            }
        }
    }
}
