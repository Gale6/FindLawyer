package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Appointments (

    @SerializedName("appointments")
    val appointments:ArrayList<Appointment>
        )