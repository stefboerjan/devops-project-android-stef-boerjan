package com.example.breakingbadapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var quote: String = "",
    var author: String = ""
)
