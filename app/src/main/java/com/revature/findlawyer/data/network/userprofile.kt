package com.revature.findlawyer.data.network

import androidx.compose.runtime.MutableState
import com.google.gson.annotations.SerializedName

data class user (

        @SerializedName("user_name")
        var user_name:String,
        @SerializedName("user_password")
        var user_password:String,
        @SerializedName("user_address")
        var user_address:String,
        @SerializedName("user_profile")
        var user_profile:String
        )

data class userprofile (
        @SerializedName("userprofile")
        val userprofile:user
        )