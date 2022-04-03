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
    object Screen_Histories:DrawerScreens("Histories",Icons.Default.ShoppingCart,"Histories")
    object Screen_CurrentAppointments:DrawerScreens("Appointment",Icons.Default.ShoppingCart,"CurrentAppointments")
    object Screen_ScheduleNewAppointment:DrawerScreens("ScheduleNewAppointment",Icons.Default.ShoppingCart,"ScheduleNewAppointment")

    object Screen_LawyerSearch:DrawerScreens("Lawyer Search",Icons.Default.ShoppingCart,"LawyerSearch")
    object Screen_PostReview:DrawerScreens("Post Review",Icons.Default.ShoppingCart,"PostReview")


    object LawyerRegister:DrawerScreens("Lawyer Register",Icons.Default.ArrowDropDown,"lawyer_register")
    object UserRegister:DrawerScreens("User Register",Icons.Default.ArrowDropDown,"user_register")


}
//These will show up on drawer list & the Bottom Nav Bar
val Screens= listOf(

    //delete below and start from search
    DrawerScreens.MainOverallScreen,
    DrawerScreens.Screen_CurrentAppointments,
    DrawerScreens.Screen_Histories,
    DrawerScreens.UserLogIn,

//need search
//need currentAppointment
//profile
//histories


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
        onClick = {
            navController.navigate(screen.route)
        {
            popUpTo(navController.graph.findStartDestination().id){ saveState=true }
            launchSingleTop=true
            restoreState=true
         }
        }

    )
}