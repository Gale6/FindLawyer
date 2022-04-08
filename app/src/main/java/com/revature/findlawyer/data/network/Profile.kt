package com.revature.findlawyer.data.network

import androidx.compose.runtime.MutableState
import com.google.gson.annotations.SerializedName

data class Profile (
        @SerializedName("user_name")
        val user_name:String,
        @SerializedName("user_password")
        val user_password:String,
        @SerializedName("user_address")
        val user_address:String,
        @SerializedName("user_profile")
        val user_profile:String
        )