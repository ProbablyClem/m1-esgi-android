package com.example.pokeapp.modelView


import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pokeapp.R
import com.example.pokeapp.databinding.ActivityDetailBinding
import com.example.pokeapp.model.DetailModel
import com.example.pokeapp.model.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.round

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var model: DetailModel
    private var typePokemonColor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        lifecycleScope.launch(Dispatchers.Main) {
            model = DetailModel()
            val result = withContext(Dispatchers.IO) {
                model.getLastPokemon()
            }
            binding.pokemonName.text = result.name
        }

        typePokemonColor = getColor(R.color.Poison)
        binding.container.setBackgroundColor(typePokemonColor)
        binding.about.setTextColor(typePokemonColor)
        binding.baseStatTitle.setTextColor(typePokemonColor)
        binding.arrowBack.setOnClickListener() {
            val intent = Intent(this, ListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
        binding.typeComponent.setColorFilter(typePokemonColor)
        binding.statHp.progress = round((120.0/255)*100).toInt()
        binding.statHp.progressTintList = ColorStateList.valueOf(typePokemonColor)
        binding.hpText.setTextColor(typePokemonColor)
        binding.attackText.setTextColor(typePokemonColor)
        binding.defText.setTextColor(typePokemonColor)
        binding.sAttText.setTextColor(typePokemonColor)
        binding.sDefText.setTextColor(typePokemonColor)
        binding.speedText.setTextColor(typePokemonColor)
        setContentView(binding.root)
    }
}

//@+id/description max size 100 characters