package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Appointment (

    @SerializedName("id")
    val id:Int,
    @SerializedName("firstName") 
    val firstName:String,
    @SerializedName("lastName")
    val lastName:String,
    @SerializedName("rating")
    val rating:Float,
    @SerializedName("typeOfPractice")
    val typeOfPractice:String,
    @SerializedName("numCases")
    val numOfCases:Int,
    @SerializedName("img")
    val img:String,
    @SerializedName("time")
    val time:String


)