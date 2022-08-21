package com.example.breakingbadapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.breakingbadapp.domain.Episode

@Entity(tableName = "episodes")
data class DatabaseEpisode(
    @PrimaryKey(autoGenerate = true)
    var id: String = "",
    var title: String = "",
    var season: Int = -1,
    var episode: Int = -1,
    var air_date: String = "",
    var characters: List<String> = emptyList()
)

fun List<DatabaseEpisode>.asDomainModel(): List<Episode> {
    return map {
        Episode(
            id = it.id,
            title = it.title,
            season = it.season,
            episode = it.episode,
            air_date = it.air_date,
            characters = it.characters
        )
    }
}
