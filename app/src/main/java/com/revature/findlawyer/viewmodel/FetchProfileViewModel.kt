package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.MutableRect
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Profile
import com.revature.findlawyer.data.repository.ProfileHelper
import com.revature.findlawyer.data.repository.ProfileAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FetchProfileViewModel: ViewModel() {
    private val fetchProfileLiveData = MutableLiveData<Profile>()
    //var profileResult: MutableState<Profile> = mutableStateOf<Profile>()

    lateinit var profileResult: MutableState<Profile>

    init {
        fetchProfile()
    }

    fun fetchProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profileService = ProfileHelper.getProfileService()
                val responseService = profileService.getProfile()

                if(responseService.isSuccessful) {
                    responseService.body()?.let { it ->
                        profileResult.value = it.copy()
                        Log.d("Profile Service",responseService.body().toString())
                    }
                } else {
                    responseService.errorBody()?.let { error ->
                        Log.d("Retrieval Error", "Response Token $error")
                        error.close()
                    }
                }

                fetchProfileLiveData.postValue(responseService.body())

            } catch (e:Exception) {
                Log.d("Profile", "Exception")
            }
        }
    }
}