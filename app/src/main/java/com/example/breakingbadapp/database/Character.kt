package com.example.breakingbadapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey(autoGenerate = true)
    var characterId: Long = 0L,
    var name: String = "",
    var birthday: String = "",
    var occupation: List<String> = emptyList(),
    var img: String = "",
    var status: String = "",
    var nickname: String = "",
    var appearance: List<Int> = emptyList(),
    var portrayed: String = ""
)
