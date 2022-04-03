package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class LawyerLogin (
    @SerializedName("lawyer_username")
    val lusername:String,

    @SerializedName("lawyer_password")
    val lpassword:String,

        )