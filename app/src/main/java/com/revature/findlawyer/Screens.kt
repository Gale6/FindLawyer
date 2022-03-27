package com.revature.findlawyer

sealed class DrawerScreens (val title: String, val route:String){

    object LawyerLogin:DrawerScreens("Lawyer_LogIn","lawyer_login")
    object UserLogIn:DrawerScreens("User_LogIn","user_login")

}

val Screens= listOf(
    DrawerScreens.LawyerLogin,
    DrawerScreens.UserLogIn,

)