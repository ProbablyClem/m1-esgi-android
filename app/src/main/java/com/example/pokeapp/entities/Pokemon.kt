package com.example.pokeapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    var pokemon_id: Int,
    var name: String,
) {
    constructor() : this(0, "")
}
