package com.example.pokeapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    val pokemon_number: Int,
    val name: String,
)
