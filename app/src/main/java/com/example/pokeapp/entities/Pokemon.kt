package com.example.pokeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    var pokemon_id: Int,
    var name: String,
    @ColumnInfo(name = "insertion_timestamp")
    var insertionTimestamp: Long
) {
    constructor() : this(0, "", 0)
}
