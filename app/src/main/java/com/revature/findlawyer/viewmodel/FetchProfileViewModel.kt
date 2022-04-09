package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.MutableRect
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.data.network.user
import com.revature.findlawyer.data.network.userprofile
import com.revature.findlawyer.data.repository.ProfileHelper
import com.revature.findlawyer.data.repository.ProfileAPIService
import com.revature.findlawyer.ui.Screen_CustomerProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.logging.Logger.global
var uname = ""
var uadd = ""
var upass = ""
var upro = ""

class FetchProfileViewModel: ViewModel() {
    private val fetchProfileLiveData = MutableLiveData<userprofile>()
    var profileResult: MutableState<userprofile> = mutableStateOf<userprofile>(userprofile(user("","","","")))
    //lateinit var profile:MutableState<Profile>
    //var profilePass: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    //var profileAdd: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    //var profilePro: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    //var uname = ""

    init {
        fetchProfile()
    }

    fun fetchProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profileService = ProfileHelper.getProfileService()
                //Log.d("ProfileService", "getprofileservice")
                val responseService = profileService.getProfile()
                //Log.d("responseService", responseService.body().toString())

                if(responseService.isSuccessful) {

                    responseService.body()?.let { it ->
                        Log.d("logging successful", "Response token $it")
                        //profileResult.value = it
                        //Log.d("output",it.userprofile.user_name)
                        uname = it.userprofile.user_name
                        upass = it.userprofile.user_password
                        uadd = it.userprofile.user_address
                        upro = it.userprofile.user_profile
                        //profileResult.value.userprofile.user_password = it.userprofile.user_password
                        //profileResult.value.userprofile.user_address = it.userprofile.user_address
                        //profileResult.value.userprofile.user_profile = it.userprofile.user_profile
                        //Log.d("output", profileResult.value.userprofile.user_name)
                    }
                    //Log.d("Profile Service", responseService.toString())
                } else {
                    responseService.errorBody()?.let { error ->
                        Log.d("Retrieval Error", "Response Token $error")
                        error.close()
                    }
                }

                fetchProfileLiveData.postValue(responseService.body())


            } catch (e:Exception) {
                Log.d("Profile", e.toString())
            }
        }
    }

    fun setName(name:String) {
        var uname = name
    }

}