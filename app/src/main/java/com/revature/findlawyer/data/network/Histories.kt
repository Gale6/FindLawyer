package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Histories(

    @SerializedName("histories")
    val histories: List<History>
)
