package com.revature.findlawyer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.data.network.LawyerLogin
import com.revature.findlawyer.ui.*
import com.revature.findlawyer.ui.lawyersearch.Screen_LawyerSearch
import com.revature.findlawyer.ui.postreview.screen_postReview
import com.revature.findlawyer.ui.ui.Screen_AppointmentMade
import com.revature.findlawyer.viewmodel.AppointmentViewModel
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel
import com.revature.findlawyer.viewmodel.LawyerLoginViewModel
import com.revature.findlawyer.viewmodel.UserLoginViewModel
import com.revature.findlawyer.viewmodel.UserRegisterViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavHostGraph(navController: NavHostController,appointmentViewModel: AppointmentViewModel,fetchLawyersViewModel: FetchLawyersViewModel) {

    NavHost(navController = navController, startDestination = DrawerScreens.MainOverallScreen.route)
    {

        composable(DrawerScreens.MainOverallScreen.route) {
            MainOverllScreen (navController = navController)
        }


        composable(DrawerScreens.MainLawyer.route) {
            MainLawyer (navController = navController)
        }


        composable(DrawerScreens.MainUser.route) {
            MainUser ( navController=navController)
        }


        composable(DrawerScreens.LawyerLogin.route) {
            LawyerLogIn ( navController=navController,viewModel = LawyerLoginViewModel())
        }


        composable(DrawerScreens.UserLogIn.route) {
            UserLogIn ( navController=navController,viewModel = UserLoginViewModel())
        }

        composable(DrawerScreens.Screen_CurrentAppointments.route){
            Screen_CurrentAppointmentScreen(navController,viewModel = appointmentViewModel)
        }

        composable(DrawerScreens.Screen_Histories.route){
            Screen_Histories(navController,viewModel = appointmentViewModel)
        }

        composable(DrawerScreens.Screen_AppointmentUpdated.route){
            Screen_AppointmentMade(navController,"your appointment has been updated")
        }

        composable(DrawerScreens.Screen_AppointmentMade.route){
            Screen_AppointmentMade(navController,"your appointment has been made")
        }

        composable(DrawerScreens.Screen_AppointmentCanceled.route){
            Screen_AppointmentMade(navController,"your appointment has been Canceled")
        }

        composable(DrawerScreens.Screen_LawyerSearch.route){
            Screen_LawyerSearch(navHostController = navController, viewModel = fetchLawyersViewModel)
        }

        composable(DrawerScreens.Screen_PostReview.route){
            screen_postReview(navHostController = navController)
        }

        composable(DrawerScreens.Screen_ScheduleNewAppointment.route){

            Screen_ScheduleNewAppointment(navController = navController, appointmentViewModel = appointmentViewModel, lawyersViewModel = fetchLawyersViewModel)
        }




        composable(DrawerScreens.LawyerRegister.route) {
            Registerlawyer(navController = navController)
        }

        composable(DrawerScreens.UserRegister.route) {
            Registeruser(navController = navController, UserRegisterViewModel())
        }

        composable(DrawerScreens.Profile.route){
            Screen_CustomerProfile(navController)
        }
    }
}