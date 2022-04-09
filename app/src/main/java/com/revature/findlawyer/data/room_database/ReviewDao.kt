package com.revature.findlawyer.data.room_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReview(review: RReview)

    @Query("SELECT * FROM review_table ORDER BY reviewId ASC")
    fun readAllData(): LiveData<List<RReview>>

    @Query("SELECT * FROM review_table")
    fun getAll(): LiveData<List<RReview>>
}