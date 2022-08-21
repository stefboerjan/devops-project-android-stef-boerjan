package com.example.breakingbadapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BreakingBadDatabaseDao {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<DatabaseCharacter>>

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): LiveData<List<DatabaseEpisode>>

    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): LiveData<List<DatabaseQuote>>

    @Query("SELECT * FROM episodes where id = :key")
    fun getQuote(key: Long): DatabaseQuote?

    @Query("SELECT * FROM quotes ORDER BY RAND () LIMIT 1")
    fun getRandomQuote(): DatabaseQuote?

    @Insert
    fun insert(quote: DatabaseQuote)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCharacters(vararg characters: DatabaseCharacter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEpisodes(vararg episodes: DatabaseEpisode)
}
