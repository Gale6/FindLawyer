package com.revature.findlawyer.data.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.revature.findlawyer.data.room_database.Appointment

@Entity(tableName = "lawyer")
data class LawyerTable (

    @PrimaryKey(autoGenerate = false)
    var username:String,

    @ColumnInfo(name = "password")
    val password:String,

    @ColumnInfo(name = "firstName")
    val firstName:String ?= null,

    @ColumnInfo(name = "lastName")
    val lastName:String ?= null,

    @ColumnInfo(name = "licenseNum")
    val licenseNum:String ?= null,

    @ColumnInfo(name = "phoneNum")
    val phoneNum:String ?= null,

    @ColumnInfo(name = "typeOfPractice")
    val typeOfPractice:ArrayList<String> ?= null,

    @ColumnInfo(name = "ratings")
    val ratings:ArrayList<Short> ?= null,

    @ColumnInfo(name = "reviews")
    val reviews:ArrayList<String> ?= null,

    @ColumnInfo(name = "appointment")
    val appointments:ArrayList<Appointment> ?= null,

    )