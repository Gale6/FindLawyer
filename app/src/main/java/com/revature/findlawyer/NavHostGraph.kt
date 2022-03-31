package com.revature.findlawyer

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.ui.MainLawyer
import com.revature.findlawyer.ui.MainOverllScreen
import com.revature.findlawyer.ui.MainUser
import com.revature.findlawyer.ui.bottDrawer
import kotlinx.coroutines.launch

@Composable
fun NavHostGraph(navController: NavHostController) {

    //val navController = rememberNavController()


    NavHost(navController = navController, startDestination = DrawerScreens.MainOverallScreen.route)
    {

        composable(DrawerScreens.MainOverallScreen.route)//change name
        {

                    MainOverllScreen (navController = navController)
        }


        composable(DrawerScreens.MainLawyer.route)//change name
        {

                    MainLawyer (navController = navController)
        }



        composable(DrawerScreens.MainUser.route)//change name
        {

                    MainUser ( navController=navController)
        }


        composable(DrawerScreens.LawyerLogin.route)//change name
        {

//                    LawyerLogin ( navController=navController)
        }


        composable(DrawerScreens.UserLogIn.route)//change name
        {

//                    UserLogIn ( navController=navController)
        }

    }
}




