package com.revature.findlawyer.data.network

import com.google.gson.annotations.SerializedName

data class Lawyer (

    @SerializedName("id")
    val id:Int,
    @SerializedName("firstName")        //will convert to JSON
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
    val img:String

)