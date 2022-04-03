package com.revature.findlawyer.data.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {

    private val retrofit: Retrofit

    init {

        val builder = Retrofit.Builder()
            .baseUrl("https://private-8a17fb-currentappointment.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .writeTimeout(0, TimeUnit.MICROSECONDS)
            .writeTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient).build()
    }

    fun getAppointmentService(): AppointmentService {

        return retrofit.create(AppointmentService::class.java)
    }


}