package com.revature.findlawyer.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.LawyerLogin
import com.revature.findlawyer.data.repository.LawyerRetrofitHelper
import com.revature.findlawyer.data.repository.RetrofitHelper
import com.revature.findlawyer.ui.LawyerLogIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class LawyerLoginViewModel:ViewModel() {

    private val lawerLoginLiveData=MutableLiveData<Boolean>()

    fun lLogin(username:String, password:String){

        viewModelScope.launch(Dispatchers.IO){

            try {
                val authService= LawyerRetrofitHelper.getLawyerService()
                val responseService=authService.getLawyerLogin(LawyerLogin(lusername = username,lpassword = password))

                if(responseService.isSuccessful){
                    responseService.body()?.let{LawyerToken->
                        Log.d( "User Login Success", "Response Token $LawyerToken")

                    }
                }else{
                    responseService.errorBody()?.let{error->
                        error.close()
                    }
                }

                lawerLoginLiveData.postValue(responseService.isSuccessful)

            }catch (e:Exception){
                Log.d("Network exception log", "Exception in networking $e")
            }
        }
    }

}