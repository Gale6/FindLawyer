package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class UserRegister(
    @SerializedName("user_username")
    val uusername:String,

    @SerializedName("user_password")
    val upassword:String,

    @SerializedName("user_ufirstname")
    val ufirstname:String,

    @SerializedName("user_ulastname")
    val ulastname:String,
)
