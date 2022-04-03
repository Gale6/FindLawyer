package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class AvailableAppointments (
    @SerializedName("availableTime")
    val availableTime:List<String>
)