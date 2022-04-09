package com.revature.findlawyer.data.room_database

import androidx.lifecycle.LiveData
//import com.revature.findlawyer.ui.reviewList

class ReviewRepository (private val reviewDao: ReviewDao){
    val readAllData: LiveData<List<RReview>> = reviewDao.readAllData()

    suspend fun addReview(review:RReview){
        reviewDao.addReview(review)
    }

    suspend fun getAll() {
        reviewDao.getAll()
    }
}