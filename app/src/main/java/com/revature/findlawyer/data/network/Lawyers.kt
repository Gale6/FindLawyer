package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Lawyers (
    @SerializedName("lawyers")
    val lawyers:List<Lawyer>
        )