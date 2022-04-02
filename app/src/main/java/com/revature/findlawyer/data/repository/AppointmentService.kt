package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AppointmentService {

    @POST("/fetch_appointments")
    suspend fun getAppointments(@Body token: Token):Response<Appointments>

    @POST("/available_appointments")
    suspend fun getAvailableAppointments(@Body lawyerName:String):Response<AvailableAppointments>

    @POST("/update_appointment")
    suspend fun updateAppointment(@Body oldAppointments: Appointment, newAppointments:Appointment):Response<String>

    @POST("/delete_appointment")
    suspend fun deleteAppointment(@Body targetAppointment:Appointment):Response<String>

    @POST("/new_appointment")
    suspend fun newAppointment(@Body token: Token, newAppointment:Appointment):Response<String>

    @POST("/history")
    suspend fun fetchHistory(@Body token: Token):Response<Histories>

}