package com.revature.findlawyer

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.data.network.LawyerLogin
import com.revature.findlawyer.ui.*
import com.revature.findlawyer.viewmodel.AppointmentViewModel
import com.revature.findlawyer.viewmodel.LawyerLoginViewModel
import com.revature.findlawyer.viewmodel.UserLoginViewModel
import kotlinx.coroutines.launch

@Composable
fun NavHostGraph(navController: NavHostController,appointmentViewModel: AppointmentViewModel) {

    NavHost(navController = navController, startDestination = DrawerScreens.Screen_CurrentAppointments.route)
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


    }
}