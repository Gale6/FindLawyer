package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class UserLogin (

    @SerializedName("user_username")
    val uusername:String,

    @SerializedName("user_password")
    val upassword:String,


        )