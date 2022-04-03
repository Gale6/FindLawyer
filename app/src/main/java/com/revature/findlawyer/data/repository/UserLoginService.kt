package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.LawyerLogin
import com.revature.findlawyer.data.network.LawyerToken
import com.revature.findlawyer.data.network.UserLogin
import com.revature.findlawyer.data.network.UserToken
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginService {

    @POST("/Uauthentication")//this is the final part of the url from apiary
    suspend fun getUserLogin (@Body userlogin: UserLogin): Response<UserToken>

}