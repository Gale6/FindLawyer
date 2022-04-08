package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Profile (
        @SerializedName("user_id")
        val user_id:Int,
        @SerializedName("user_image")
        val user_image:String,
        @SerializedName("user_name")
        val user_name:String,
        @SerializedName("user_profile")
        val user_profile:String
        )