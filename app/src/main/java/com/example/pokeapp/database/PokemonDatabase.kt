package com.example.pokeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pokeapp.dao.PokemonDao
import com.example.pokeapp.entities.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 2,
    exportSchema = false
)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Perform any necessary data migration or schema changes here
                // This is a simple version increment, so you might not need to do anything
            }
        }
    }
}