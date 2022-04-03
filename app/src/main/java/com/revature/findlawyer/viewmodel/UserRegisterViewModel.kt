package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.UserRegister
import com.revature.findlawyer.data.repository.UserRetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRegisterViewModel: ViewModel() {
    private val userRegisterLiveData=MutableLiveData<Boolean>()
    fun uRegister(username: String,password: String,firstname:String,lastname:String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val authService = UserRetrofitHelper.getUserRegisterService()
                val responseService = authService.getUserRegister(
                    userRegister = UserRegister(
                        username,
                        password,
                        firstname,
                        lastname
                    )
                )
                userRegisterLiveData.postValue(responseService.isSuccessful)

            } catch (e: Exception) {
                Log.d("Network exception log", "Exception in networking $e")
            }
        }
    }
    fun issuccessful(): Boolean? {
        return userRegisterLiveData.value
    }
}