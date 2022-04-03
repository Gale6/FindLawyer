package com.revature.findlawyer.data.repository

import com.google.gson.annotations.SerializedName
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.data.network.Lawyers

import retrofit2.Response

import retrofit2.http.GET

interface LawyerSearchAPIService {

    @GET("lawyers")
    suspend fun getLawyerList(): Response<Lawyers>
}