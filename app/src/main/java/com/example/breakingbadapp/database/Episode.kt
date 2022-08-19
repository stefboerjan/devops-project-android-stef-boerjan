package com.example.breakingbadapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class Episode(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var title: String = "",
    var season: Int = -1,
    var episode: Int = -1,
    var air_date: String = "",
    var characters: List<String> = emptyList()
)
