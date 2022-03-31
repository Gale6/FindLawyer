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

//                    MainOverllScreen (navController = navController)
        }


        composable(DrawerScreens.MainLawyer.route)//change name
        {

//                    MainLawyer (navController = navController)
        }



        composable(DrawerScreens.MainUser.route)//change name
        {

//                    MainUser ( navController=navController)
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



///////////////////// These below maybe go with the drawer ///////////////////////////////////////

//    Surface(
//        color= MaterialTheme.colors.background
//
//    ) {
//
//        var drawerState= rememberDrawerState(DrawerValue.Closed )
//        var scope= rememberCoroutineScope() //corouitines
//        var openDrawer = {
//
//            scope.launch {
//
//                drawerState.open()
//            }
//        }
//
//        ////////////////////////////////  ModalDrawer  ///////////////////////////////////////
//
//        ModalDrawer(
//
//            drawerState=drawerState,
//            gesturesEnabled = drawerState.isOpen,
//            drawerContent = {
//
//                bottDrawer(onDestinationClicked = { route ->
//
//                    scope.launch {
//
//                        drawerState.close()
//
//                    }
//                    navController.navigate(route)
//                    {
//                        popUpTo=navController.graph.startDestinationId //replaced
//                        //popUpToId=navController.graph.startDestinationId
//                        launchSingleTop=true
//                    }
//                })
//            }
//
//
//        ) {
//            NavHost(navController = navController, startDestination = DrawerScreens.MainOverallScreen.route)
//            {
//
//                composable(DrawerScreens.MainOverallScreen.route)//change name
//                {
//
////                    MainOverllScreen (navController = navController)
//                }
//
//
//                composable(DrawerScreens.MainLawyer.route)//change name
//                {
//
////                    MainLawyer (navController = navController)
//                }
//
//
//
//                composable(DrawerScreens.MainUser.route)//change name
//                {
//
////                    MainUser ( navController=navController)
//                }
//
//
//                composable(DrawerScreens.LawyerLogin.route)//change name
//                {
//
////                    LawyerLogin ( navController=navController)
//                }
//
//
//                composable(DrawerScreens.UserLogIn.route)//change name
//                {
//
////                    UserLogIn ( navController=navController)
//                }
//
//            }
//        }
//
//              //maybe use this call for the rest of the screens
//              MainLawyer (openDrawer ={ openDrawer() })
//
//
//
//        }
//
//    }

