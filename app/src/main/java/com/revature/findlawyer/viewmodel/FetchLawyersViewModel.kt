package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.data.network.Lawyers
import com.revature.findlawyer.data.repository.LawyerSearchHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FetchLawyersViewModel: ViewModel() {

    private val fetchLawyersLiveData=MutableLiveData<Lawyers>() // make list of Lawyer
    var lawyerResultList: MutableState<List<Lawyer>> = mutableStateOf(listOf())

    init {
        lawyersList()
    }

    fun lawyersList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val lawyerService= LawyerSearchHelper.getLawyerService()

                val responseService=lawyerService.getLawyerList()   //

                if(responseService.isSuccessful) {
                    //if you recieve a response from server
                    responseService.body()?.let { it ->
                        lawyerResultList.value = it.lawyers
                    }
                } else {

                    responseService.errorBody()?.let { error ->
                        Log.d("Retrieval Error", "Response Token $error")
                        error.close()
                    }
                }


                fetchLawyersLiveData.postValue(responseService.body())
            } catch(e:Exception) {
                Log.d("LawyerSearch", "Exception")
            }
        }


    }

}