package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class History(

    @SerializedName("id")
    val id:Int,
    @SerializedName("firstName")
    val firstName:String,
    @SerializedName("lastName")
    val lastName:String,
    @SerializedName("typeOfPractice")
    val typeOfPractice:String,
    @SerializedName("rating")
    val rating:Float,
    @SerializedName("numCases")
    val numCases:Int,
    @SerializedName("img")
    val img:String,
    @SerializedName("time")
    val time:String,

)


