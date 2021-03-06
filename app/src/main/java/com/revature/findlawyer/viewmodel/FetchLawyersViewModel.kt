package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.compose.runtime.*
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
    var selectedSortFilter: MutableState<String> = mutableStateOf("All")
    var selectedLawyerFilter: MutableState<String> = mutableStateOf("All")


    lateinit var clickedLawyer:MutableState<Lawyer>

    init {
        lawyersList()
    }

    fun getSortFilter() : String {
        return selectedSortFilter.value
    }

    fun setSortFilter(filter:String) {
        selectedSortFilter.value = filter
    }

    fun getTypeFilter() : String {
        return selectedLawyerFilter.value
    }

    fun setTypeFilter(filter:String) {
        selectedLawyerFilter.value = filter
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
                        Log.d("Lawyer Service",responseService.body().toString())
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