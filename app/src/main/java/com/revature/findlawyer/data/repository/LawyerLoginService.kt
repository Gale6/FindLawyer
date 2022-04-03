package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.LawyerLogin
import com.revature.findlawyer.data.network.LawyerToken
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LawyerLoginService {

    @POST("/LAauthentication")//this is the final part of the url from apiary
    suspend fun getLawyerLogin(@Body lawyerLogin:LawyerLogin): Response<LawyerToken>

}