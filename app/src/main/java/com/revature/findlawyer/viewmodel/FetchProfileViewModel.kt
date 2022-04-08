package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.MutableRect
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.data.network.Profile
import com.revature.findlawyer.data.repository.ProfileHelper
import com.revature.findlawyer.data.repository.ProfileAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FetchProfileViewModel: ViewModel() {
    private val fetchProfileLiveData = MutableLiveData<Profile>()
    //var profileResult: MutableState<Profile> = mutableStateOf<Profile>(Profile())
    //lateinit var profile:MutableState<Profile>
    //var profilePass: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    //var profileAdd: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    //var profilePro: MutableState<Profile> = mutableStateOf<Profile>(Profile("","","",""))
    var name = ""


    init {
        fetchProfile()

    }

    fun fetchProfile() {



        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profileService = ProfileHelper.getProfileService()
                Log.d("ProfileService", "getprofileservice")
                val responseService = profileService.getProfile()
                Log.d("responseService", responseService.body().toString())

                if(responseService.isSuccessful) {
                    Log.d("test", responseService.body()!!.user_name)
//                    responseService.body()?.let { it ->
//                        name = it.profiles
                        //Log.d("Profile Service",responseService.body()?)
//                    }
                    Log.d("Profile Service", responseService.toString())
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
    fun setProfile(name:String, pass:String, add:String, profile:String) {

    }
}