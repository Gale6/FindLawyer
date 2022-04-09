package com.revature.findlawyer.data.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RReview::class], version = 1, exportSchema = false)
abstract class ReviewDatabase: RoomDatabase() {
    abstract fun ReviewDao(): ReviewDao

    companion object{
        @Volatile
        private var INSTANCE: ReviewDatabase? = null

        fun getDatabase(context: Context): ReviewDatabase {
           val tempInstance = INSTANCE
           if (tempInstance != null){
               return tempInstance
           }
           synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   ReviewDatabase::class.java,
                   "review_database"
               ).build()
               INSTANCE = instance
               return instance
           }

        }
    }
}