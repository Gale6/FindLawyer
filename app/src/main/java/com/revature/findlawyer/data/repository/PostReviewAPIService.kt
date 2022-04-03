package com.revature.findlawyer.data.repository

import com.revature.findlawyer.data.network.Lawyers
import com.revature.findlawyer.data.network.Review
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostReviewAPIService {

    @POST("post_review")
    suspend fun postReview(@Body newReview: Review): Response<String>
}