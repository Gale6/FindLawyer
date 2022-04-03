package com.revature.findlawyer.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.UserLogin
import com.revature.findlawyer.data.network.UserToken
import com.revature.findlawyer.data.repository.RetrofitHelper
import com.revature.findlawyer.data.repository.UserRetrofitHelper
import com.revature.findlawyer.ui.UserLogIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserLoginViewModel: ViewModel() {

    private val userLoginLiveData=MutableLiveData<Boolean>()
    val logincred: MutableState <Boolean> = mutableStateOf(true)

    fun uLogin(username:String,password:String){

        viewModelScope.launch(Dispatchers.IO){

            try {
                val authService=UserRetrofitHelper.getUserService()
                val responseService=authService.getUserLogin(UserLogin(uusername=username,upassword = password))
                if(responseService.isSuccessful){
                    responseService.body()?.let{UserToken->
                        Log.d( "User Login Success", "Response Token $UserToken")
                        //Toast.makeText(context,"Airplane Mode Enabled", Toast.LENGTH_LONG).show()
                    }
                }else{
                    responseService.errorBody()?.let{error->
                        error.close()
                    }
                }

                userLoginLiveData.postValue(responseService.isSuccessful)


            }catch (e:Exception){
                Log.d( "Network exception log", "Exception in networking $e")
            }
        }
    }

}

