package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Appointment
import com.revature.findlawyer.data.network.History
import com.revature.findlawyer.data.network.Token
import com.revature.findlawyer.data.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AppointmentViewModel:ViewModel() {

    private val fetchAppointmentRequestLiveData = MutableLiveData<Boolean>()

    var result: MutableState<ArrayList<Appointment>> = mutableStateOf(arrayListOf())

    var histories: MutableState<List<History>> = mutableStateOf(listOf())

    var listOfAvailableTime: MutableState<List<String>> = mutableStateOf(listOf())

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
                        Log.d("appointments error",ResponseBody.toString(   ))
                        ResponseBody.close()
                    }
                }
                fetchAppointmentRequestLiveData.postValue(responseService.isSuccessful)
            }catch (e:Exception){

                Log.d("appointments", "Expection in networking $e")

            }
        }
    }

    fun newAppointment(name:String,targetName: String,time: String){

        viewModelScope.launch {
            try {
                val newAppointmentService = RetrofitHelper.getAppointmentService()

                val responseService = newAppointmentService.newAppointment(token = Token("adfadfadfaf"),Appointment(name,targetName,time)
                )

                if(responseService.isSuccessful){
                    responseService.body()?.let{
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

    fun fetchAvailableAppointment(){

        viewModelScope.launch {

            try {
                val fetchAvailableAppointmentService = RetrofitHelper.getAppointmentService()

                val responseService = fetchAvailableAppointmentService.getAvailableAppointments("lawyer1")

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                            it ->
                        listOfAvailableTime.value = it.availableTime
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

    fun updateAppointment(name:String,targetName:String,time:String,newTime:String){

        viewModelScope.launch {
            try {
                val updateAppointmentService = RetrofitHelper.getAppointmentService()
                val responseService = updateAppointmentService.updateAppointment(Appointment(name, targetName,time),Appointment(name, targetName,newTime))

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                        Log.d("updated","appointment")
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

    fun deleteAppointment(name:String,targetName: String,time: String){

        viewModelScope.launch {
            try {
                val deleteAppointmentService = RetrofitHelper.getAppointmentService()
                val responseService = deleteAppointmentService.deleteAppointment(Appointment(name,targetName,time))

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                        Log.d("delete","appointment")
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

    fun fetchHistory(){
        viewModelScope.launch {
            try {
                val fetchHistoryService = RetrofitHelper.getAppointmentService()
                val responseService = fetchHistoryService.fetchHistory(Token("dafsdfafsdsaf"))

                if(responseService.isSuccessful){
                    responseService.body()?.let{
                        it ->
                        histories.value = it.histories

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

