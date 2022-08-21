package com.example.breakingbadapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.breakingbadapp.domain.Character

@Entity(tableName = "characters")
data class DatabaseCharacter(
    @PrimaryKey(autoGenerate = true)
    var characterId: String = "",
    var name: String = "",
    var birthday: String = "",
    var occupation: List<String> = emptyList(),
    var img: String = "",
    var status: String = "",
    var nickname: String = "",
    var appearance: List<String> = emptyList(),
    var portrayed: String = ""
)

fun List<DatabaseCharacter>.asDomainModel(): List<Character> {
    return map {
        Character(
            id = it.characterId,
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
