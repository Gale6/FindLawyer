package com.revature.findlawyer

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.findlawyer.ui.bottDrawer
import kotlinx.coroutines.launch

@Composable
fun NavHostGraph(navController: NavHostController){

    val navController= rememberNavController()

    Surface(
        color= MaterialTheme.colors.background

    ) {

        var drawerState= rememberDrawerState(DrawerValue.Closed )
        var scope= rememberCoroutineScope() //corouitines
        var openDrawer = {

            scope.launch {

                drawerState.open()
            }
        }

        ////////////////////////////////  ModalDrawer  ///////////////////////////////////////

        ModalDrawer(

            drawerState=drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {

                bottDrawer(onDestinationClicked = { route ->

                    scope.launch {

                        drawerState.close()

                    }
                    navController.navigate(route)
                    {
                        popUpTo=navController.graph.startDestinationId //replaced
                        //popUpToId=navController.graph.startDestinationId
                        launchSingleTop=true
                    }
                })
            }


        ) {

            NavHost(navController = navController, startDestination = DrawerScreens.Home.route)
            {

                composable(DrawerScreens.Home.route)//change name
                {

//                    Home (openDrawer ={ openDrawer() })
                }


                composable(DrawerScreens.Account.route)//change name
                {

//                    Account (openDrawer ={ openDrawer() })
                }



                composable(DrawerScreens.Help.route)//change name
                {

//                    Help ( navController=navController)
                }

                //add more composabe Screens here

            }

        }

    }

}