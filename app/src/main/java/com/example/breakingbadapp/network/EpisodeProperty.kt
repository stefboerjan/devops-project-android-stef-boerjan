package com.example.breakingbadapp.network

import android.os.Parcelable
import com.example.breakingbadapp.database.DatabaseEpisode
import com.example.breakingbadapp.domain.Episode
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class NetworkEpisodeContainer(val episodes: List<EpisodeProperty>)

@Parcelize
@JsonClass(generateAdapter = true)
data class EpisodeProperty(
    @Json(name = "episode_id")
    val id: String,
    val title: String,
    val season: Int,
    val episode: Int,
    val air_date: String,
    val characters: List<String>
) : Parcelable

fun NetworkEpisodeContainer.asDomainModel(): List<Episode> {
    return episodes.map {
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

fun NetworkEpisodeContainer.asDatabaseModel(): Array<DatabaseEpisode> {
    return episodes.map {
        DatabaseEpisode(
            id = it.id,
            title = it.title,
            season = it.season,
            episode = it.episode,
            air_date = it.air_date,
            characters = it.characters
        )
    }.toTypedArray()
}
