package com.example.pokeapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokeapp.dao.PokemonDao
import com.example.pokeapp.entities.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1
)
abstract class PokemonDatabase: RoomDatabase() {

    abstract val dao: PokemonDao
}