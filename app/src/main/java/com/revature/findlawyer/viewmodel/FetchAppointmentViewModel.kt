package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Appointment
import com.revature.findlawyer.data.network.Token
import com.revature.findlawyer.data.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class FetchAppointmentViewModel:ViewModel() {

    private val fetchAppointmentRequestLiveData = MutableLiveData<Boolean>()

    var result: MutableState<ArrayList<Appointment>> = mutableStateOf(arrayListOf())

    init {
        fetchAppointments(token = Token("dfafafadfafdafd"))
    }


    fun fetchAppointments(token:Token) {

        viewModelScope.launch (Dispatchers.IO){

            try {
                val fetchAppointmentService = RetrofitHelper.getAppointmentService()

                val responseService = fetchAppointmentService.getAppointments(token = token)

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                        it ->
                        result.value = it.appointments
                    }

                }else{
                    responseService.errorBody()?.let{
                        ResponseBody ->
                        Log.d("appointments error",ResponseBody.toString())
                        ResponseBody.close()
                    }
                }
                fetchAppointmentRequestLiveData.postValue(responseService.isSuccessful)
            }catch (e:Exception){

                Log.d("appointments", "Expection in networking $e")

            }
        }
    }
}

