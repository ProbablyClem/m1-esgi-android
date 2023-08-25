package com.example.pokeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ProvidedAutoMigrationSpec

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    var pokemon_id: Int,
    var name: String,
    var type: String,
    var weight: String,
    var height: String,
    var capacity: String,
    var description: String,
    var image: String,
    var pv: Int,
    var attack: Int,
    var defense: Int,
    var attackSpe: Int,
    var defenseSpe: Int,
    var speed: Int,
    @ColumnInfo(name = "insertion_timestamp")
    var insertionTimestamp: Long
) {
    constructor() : this(0, "", "", "", "", "", "", "", 0, 0, 0, 0, 0, 0, 0)
}
