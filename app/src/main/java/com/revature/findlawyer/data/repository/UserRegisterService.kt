package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.UserRegister
import com.revature.findlawyer.data.network.UserToken
import retrofit2.Response
import retrofit2.http.Body

interface UserRegisterService {
    suspend fun getUserRegister (@Body userRegister: UserRegister): Response<UserToken>
}