package com.revature.findlawyer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.revature.findlawyer.data.room_database.RReview
//import com.revature.findlawyer.data.network.Review
import com.revature.findlawyer.data.room_database.ReviewDatabase
import com.revature.findlawyer.data.room_database.ReviewRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReviewViewModel(application: Application) : AndroidViewModel(application) {
    public val readAllData: LiveData<List<RReview>>
    private val repository: ReviewRepository

    init {
        val reviewDao = ReviewDatabase.getDatabase(application).ReviewDao()
        repository = ReviewRepository(reviewDao)
        readAllData = repository.readAllData
    }

    fun addReview(review: RReview) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addReview(review)
        }
    }
    fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAll()
        }
    }


}