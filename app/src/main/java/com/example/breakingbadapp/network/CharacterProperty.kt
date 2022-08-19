package com.example.breakingbadapp.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterProperty(
    @Json(name = "char_id")
    val id: String,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: List<String>,
    val portrayed: String
) : Parcelable
