package com.revature.findlawyer.data.repository

import com.google.gson.annotations.SerializedName
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.data.network.Lawyers
import com.revature.findlawyer.data.network.Profile

import retrofit2.Response

import retrofit2.http.GET

interface ProfileAPIService {

    @GET("profiles")
    suspend fun getProfile(): Response<Profile>
}