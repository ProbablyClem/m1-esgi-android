package com.example.pokeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pokeapp.dao.PokemonDao
import com.example.pokeapp.entities.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 3,
    exportSchema = false
)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}