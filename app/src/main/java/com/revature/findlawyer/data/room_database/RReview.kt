package com.revature.findlawyer.data.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "review_table")
data class RReview (
    @PrimaryKey(autoGenerate = true)
    val reviewId:Int,
    val firstName:String,
    val lastName:String,
    val rating:Float,
    val headline:String,
    val body:String
)