package com.example.breakingbadapp.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuoteProperty(
    @Json(name = "quote_id")
    val id: String,
    val quote: String,
    val author: String
) : Parcelable
