package com.revature.findlawyer

sealed class DrawerScreens (val title: String,val icon:Int, val route:String){

    object LawyerLogin:DrawerScreens("Lawyer_LogIn",R.drawable.ic_baseline_keyboard_arrow_right_24,"lawyer_login")
    object UserLogIn:DrawerScreens("User_LogIn", R.drawable.ic_baseline_keyboard_arrow_right_24,"user_login")


    //more screens here

}

val Screens= listOf(
    DrawerScreens.LawyerLogin,
    DrawerScreens.UserLogIn,

    //more screens here

)