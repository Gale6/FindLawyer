package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.Appointments
import com.revature.findlawyer.data.network.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppointmentService {

    @POST("/fetch_appointments")
    suspend fun getAppointments(@Body token: Token):Response<Appointments>
}