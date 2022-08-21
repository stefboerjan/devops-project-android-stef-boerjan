package com.example.breakingbadapp.network

import android.os.Parcelable
import com.example.breakingbadapp.database.DatabaseCharacter
import com.example.breakingbadapp.domain.Character
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class NetworkCharacterContainer(val characters: List<CharacterProperty>)

@Parcelize
@JsonClass(generateAdapter = true)
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

fun NetworkCharacterContainer.asDomainModel(): List<Character> {
    return characters.map {
        Character(
            id = it.id,
            name = it.name,
            birthday = it.birthday,
            occupation = it.occupation,
            img = it.img,
            status = it.status,
            nickname = it.nickname,
            appearance = it.appearance,
            portrayed = it.portrayed
        )
    }
}

fun NetworkCharacterContainer.asDatabaseModel(): Array<DatabaseCharacter> {
    return characters.map {
        DatabaseCharacter(
            characterId = it.id,
            name = it.name,
            birthday = it.birthday,
            occupation = it.occupation,
            img = it.img,
            status = it.status,
            nickname = it.nickname,
            appearance = it.appearance,
            portrayed = it.portrayed
        )
    }.toTypedArray()
}
