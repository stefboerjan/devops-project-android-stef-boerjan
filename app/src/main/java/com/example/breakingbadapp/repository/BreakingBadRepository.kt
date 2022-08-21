package com.example.breakingbadapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.breakingbadapp.database.BreakingBadDatabase
import com.example.breakingbadapp.database.asDomainModel
import com.example.breakingbadapp.domain.Character
import com.example.breakingbadapp.network.BreakingBadApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreakingBadRepository(private val database: BreakingBadDatabase) {

    val characters: LiveData<List<Character>> = Transformations.map(database.breakingBadDatabaseDao.getAllCharacters()) {
        it.asDomainModel()
    }

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val characters = BreakingBadApi.retrofitService.getCharacters().await()
            // database.breakingBadDatabaseDao.insertAllCharacters(*characters.asDatabaseModel())
        }
    }
}
