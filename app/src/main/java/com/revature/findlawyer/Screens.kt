package com.revature.findlawyer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

sealed class DrawerScreens (val title: String,val icon:ImageVector,val route:String){

    object MainOverallScreen:DrawerScreens("Home", Icons.Default.Home,"main")
    object MainLawyer:DrawerScreens("Lawyer_LogIn_Register",Icons.Default.Star,"lawyer_login_register")
    object MainUser:DrawerScreens("Lawyer_LogIn",Icons.Default.ArrowBack,"user_login_register")
    object LawyerLogin:DrawerScreens("Lawyer LogIn",Icons.Default.Face,"lawyer_login")
    object UserLogIn:DrawerScreens("User LogIn",Icons.Default.ShoppingCart,"user_login")
    object Screen_AppointmentMade:DrawerScreens("Screen_AppointmentMade",Icons.Default.ShoppingCart,"AppointmentMade")
    object Screen_Histories:DrawerScreens("Screen_Histories",Icons.Default.ShoppingCart,"Histories")
    object Screen_CurrentAppointments:DrawerScreens("CurrentAppointments",Icons.Default.ShoppingCart,"CurrentAppointments")
    object Screen_ScheduleNewAppointment:DrawerScreens("ScheduleNewAppointment",Icons.Default.ShoppingCart,"ScheduleNewAppointment")




}
//These will show up on drawer list & the Bottom Nav Bar
val Screens= listOf(

    //delete below and start from search
    DrawerScreens.MainOverallScreen,
    DrawerScreens.MainLawyer,
    DrawerScreens.MainUser,
    DrawerScreens.LawyerLogin,
    DrawerScreens.UserLogIn,

    )


@Composable
fun RowScope.AddItem(
    screen:DrawerScreens,
    currentDestination: NavDestination?,
    navController:NavHostController
){
    BottomNavigationItem(
        label = {Text(text = screen.title)},
        icon = { Icon(imageVector =screen.icon, contentDescription = "Navigation Icon" ) },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route}==true,
        onClick = { navController.navigate(screen.route){
            popUpTo(navController.graph.findStartDestination().id){ saveState=true }
            launchSingleTop=true
            restoreState=true }
        }
    )
}