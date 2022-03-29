package com.revature.findlawyer.data.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.revature.findlawyer.data.room_database.Appointment

@Entity(tableName = "user")
data class UserTable (

    @PrimaryKey(autoGenerate = false)
    var username:String,

    @ColumnInfo(name = "password")
    val password:String,

    @ColumnInfo(name = "firstName")
    val firstName:String ?= null,

    @ColumnInfo(name = "lastName")
    val lastName:String ?= null,

    @ColumnInfo(name = "phoneNum")
    val phoneNum:String ?= null,

    @ColumnInfo(name = "appointment")
    val appointments:ArrayList<Appointment> ?= null,

    )