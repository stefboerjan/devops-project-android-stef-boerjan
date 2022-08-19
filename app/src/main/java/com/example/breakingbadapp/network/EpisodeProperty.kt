package com.example.breakingbadapp.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeProperty(
    @Json(name = "episode_id")
    val id: String,
    val title: String,
    val season: Int,
    val episode: Int,
    val air_date: String,
    val characters: List<String>
) : Parcelable
