package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Review (
    @SerializedName("reviewId")
    val reviewId:Int,
    @SerializedName("firstName")        //will convert to JSON
    val firstName:String,
    @SerializedName("lastName")
    val lastName:String,
    @SerializedName("rating")
    val rating:Float,
    @SerializedName("headline")
    val headline:String,
    @SerializedName("body")
    val body:String
        )