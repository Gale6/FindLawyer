package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Appointment (

    @SerializedName("username")
    val username:String,

    @SerializedName("targetName")
    val targetName:String,

    @SerializedName("time")
    val time:String

)