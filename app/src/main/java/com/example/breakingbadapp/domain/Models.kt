package com.example.breakingbadapp.domain

data class Character(
    val id: String,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: List<String>,
    val portrayed: String
)

data class Episode(
    val id: String,
    val title: String,
    val season: Int,
    val episode: Int,
    val air_date: String,
    val characters: List<String>
)

data class Quote(
    val id: String,
    val quote: String,
    val author: String
)
