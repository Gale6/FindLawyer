package com.revature.findlawyer.data.repository

import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.data.network.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserLoginService {

    @POST("/Uauthentication")//this is the final part of the url from apiary
    suspend fun getUserLogin (@Body userlogin: UserLogin): Response<UserToken>

}