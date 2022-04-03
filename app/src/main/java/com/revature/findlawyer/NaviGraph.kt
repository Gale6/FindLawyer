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
import com.revature.findlawyer.viewmodel.LawyerLoginViewModel
import com.revature.findlawyer.viewmodel.UserLoginViewModel
import kotlinx.coroutines.launch

@Composable
fun NavHostGraph(navController: NavHostController) {

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


    }
}