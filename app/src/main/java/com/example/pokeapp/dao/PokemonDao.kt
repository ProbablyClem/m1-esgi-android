package com.example.pokeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.pokeapp.entities.Pokemon
@Dao
interface PokemonDao {
    @Insert
    suspend fun insertPokemon(pokemon: Pokemon)
}