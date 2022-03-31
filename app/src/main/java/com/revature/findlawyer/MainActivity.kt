package com.revature.findlawyer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.revature.findlawyer.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchAppointmentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var viewModel = FetchAppointmentViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            FindLawyerTheme {


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