package com.example.pokeapp.modelView

import PokemonAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.databinding.ActivityListBinding
import com.example.pokeapp.entities.Pokemon
import com.example.pokeapp.model.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.lifecycleScope

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var model: ListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        binding.arrowBack.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }

        val recyclerView = binding.recyclerView
        val adapter = PokemonAdapter{ clickedPokemon ->
            // Handle item click here
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("pokemon_id", clickedPokemon.pokemon_id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch(Dispatchers.Main) {
            model = ListModel()
            val result = withContext(Dispatchers.IO) {
                model.getLastPokemon()
            }
            val myList = mutableListOf(result)
            adapter.submitList(myList)
        }
        setContentView(binding.root)
    }
}