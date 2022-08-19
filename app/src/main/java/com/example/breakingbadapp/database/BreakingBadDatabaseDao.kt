package com.example.breakingbadapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BreakingBadDatabaseDao {
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): LiveData<List<Episode>>

    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM episodes where id = :key")
    fun getQuote(key: Long): Quote?

    @Query("SELECT * FROM quotes ORDER BY RAND () LIMIT 1")
    fun getRandomQuote(): Quote?

    @Insert
    fun insert(quote: Quote)
}
