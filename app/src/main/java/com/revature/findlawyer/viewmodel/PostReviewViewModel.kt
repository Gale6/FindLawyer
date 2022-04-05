package com.revature.findlawyer.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.findlawyer.data.network.Appointment
import com.revature.findlawyer.data.network.Review
import com.revature.findlawyer.data.network.Token
import com.revature.findlawyer.data.repository.AppointmentRetrofitHelper
import com.revature.findlawyer.data.repository.PostReviewHelper
import kotlinx.coroutines.launch
import java.lang.Exception

class PostReviewViewModel: ViewModel() {

    private val fetchReviewRequestLiveData = MutableLiveData<Boolean>()


    fun newReview(rating:Float,headline:String,body:String) {

        viewModelScope.launch {
            try {
                val newReviewService = PostReviewHelper.getPostReviewService()

                val responseService = newReviewService.postReview(
                    Review(
                        reviewId = 5789,
                        firstName = "Lonnie",
                        lastName = "Bragg",
                        rating = rating,
                        headline = headline,
                        body = body
                    )
                )


                if (responseService.isSuccessful) {
                    responseService.body()?.let {
                        Log.d("PostReview", "Successful")
                    }

                } else {
                    responseService.errorBody()?.let { ResponseBody ->
                        Log.d("PostReview Error", ResponseBody.toString())
                        ResponseBody.close()
                    }
                }
                fetchReviewRequestLiveData.postValue(responseService.isSuccessful)
            } catch (e: Exception) {

                Log.d("PostReview", "Exception in networking $e")

            }
        }
    }
}