package com.example.breakingbadapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Character::class, Episode::class, Quote::class], version = 1, exportSchema = false)
abstract class BreakingBadDatabase : RoomDatabase() {

    abstract val breakingBadDatabaseDao: BreakingBadDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: BreakingBadDatabase? = null

        fun getInstance(context: Context): BreakingBadDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BreakingBadDatabase::class.java,
                        "breaking_bad_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
