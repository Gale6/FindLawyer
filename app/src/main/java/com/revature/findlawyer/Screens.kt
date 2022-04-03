package com.revature.findlawyer

sealed class DrawerScreens (val title: String,val icon:Int, val route:String){

    object MainOverallScreen:DrawerScreens("Main Screen",R.drawable.ic_baseline_keyboard_arrow_right_24,"main")
    object MainLawyer:DrawerScreens("Lawyer_LogIn_Register",R.drawable.ic_baseline_keyboard_arrow_right_24,"lawyer_login_register")
    object MainUser:DrawerScreens("Lawyer_LogIn",R.drawable.ic_baseline_keyboard_arrow_right_24,"user_login_register")
    object LawyerLogin:DrawerScreens("Lawyer LogIn",R.drawable.ic_baseline_keyboard_arrow_right_24,"lawyer_login")
    object UserLogIn:DrawerScreens("User LogIn", R.drawable.ic_baseline_keyboard_arrow_right_24,"user_login")
    object UserRegister:DrawerScreens("User Register",R.drawable.ic_baseline_keyboard_arrow_right_24,"user_register")
    object LawyerRegister:DrawerScreens("Lawyer Register",R.drawable.ic_baseline_keyboard_arrow_right_24,"lawyer_register")
    object LawyerSearch:DrawerScreens("Lawyer Search",R.drawable.ic_baseline_keyboard_arrow_right_24,"lawyer_search")


}

//These will show up on drawer list
val Screens= listOf(

    //delete below and start from search
    DrawerScreens.LawyerLogin,
    DrawerScreens.MainLawyer,
    DrawerScreens.MainOverallScreen,
    DrawerScreens.MainUser,
    DrawerScreens.LawyerRegister,
    DrawerScreens.UserLogIn,
    DrawerScreens.UserRegister,
    DrawerScreens.LawyerSearch


)