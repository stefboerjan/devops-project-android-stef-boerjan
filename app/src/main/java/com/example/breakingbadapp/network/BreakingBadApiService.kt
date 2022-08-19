package com.example.breakingbadapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.example.breakingbadapp.database.Character

private const val BASE_URL = "https://www.breakingbadapi.com/api/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface BreakingBadApiService {
    @GET("characters")
    fun getCharacters():
        Deferred<List<CharacterProperty>>

    @GET("quote/random")
    fun getRandomQuote():
        Deferred<List<QuoteProperty>>

    @GET("episodes")
    fun getEpisodes():
        Deferred<List<EpisodeProperty>>
}

object BreakingBadApi {
    val retrofitService: BreakingBadApiService by lazy {
        retrofit.create(BreakingBadApiService::class.java)
    }
}
