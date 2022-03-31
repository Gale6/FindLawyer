package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Token (

    @SerializedName("accessToken")
    val accessToken: String

        )