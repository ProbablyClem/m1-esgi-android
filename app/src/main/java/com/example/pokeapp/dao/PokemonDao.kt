package com.example.pokeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeapp.entities.Pokemon
@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon ORDER BY insertion_timestamp DESC LIMIT 1")
    suspend fun getLatestPokemon(): Pokemon?
}

//ORDER BY insertion_timestamp DESC