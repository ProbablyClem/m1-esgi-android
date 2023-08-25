package com.example.pokeapp.modelView


import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.pokeapp.R
import com.example.pokeapp.database.PokemonDatabase
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
    companion object {
        lateinit var database: PokemonDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        lifecycleScope.launch(Dispatchers.Main) {
            model = DetailModel()
            val result = withContext(Dispatchers.IO) {
                model.getLastPokemon()
            }
            binding.pokemonName.text = result.name
            binding.pokemonId.text = "#" + result.pokemon_id.toString()
            binding.description.text = result.description
            //binding.pokemonImage.setImageResource(result.image.toInt())
            binding.weightValue.text = result.weight
            binding.sizeValue.text = result.height
            binding.firstCapacity.text = result.capacity
            binding.hpValue.text = result.pv.toString()
            binding.statHp.progress = model.calculProgress(result.pv)
            binding.attValue.text = result.attack.toString()
            binding.statAttack.progress = model.calculProgress(result.attack)
            binding.defValue.text = result.defense.toString()
            binding.statDefense.progress = model.calculProgress(result.defense)
            binding.sAttValue.text = result.attackSpe.toString()
            binding.statSpeAttack.progress = model.calculProgress(result.attackSpe)
            binding.sDefValue.text = result.defenseSpe.toString()
            binding.statSpeDefense.progress = model.calculProgress(result.defenseSpe)
            binding.speedValue.text = result.speed.toString()
            binding.statSpeed.progress = model.calculProgress(result.speed)

            typePokemonColor = model.getColorThemeByType(result.type , this@DetailActivity)
            binding.container.setBackgroundColor(typePokemonColor)
            binding.container.setBackgroundColor(typePokemonColor)
            binding.about.setTextColor(typePokemonColor)
            binding.baseStatTitle.setTextColor(typePokemonColor)
            binding.arrowBack.setOnClickListener() {
                val intent = Intent(this@DetailActivity, ListActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                startActivity(intent)
            }
            binding.typeComponent.setColorFilter(typePokemonColor)
            binding.statHp.progressTintList = ColorStateList.valueOf(typePokemonColor)
            binding.hpText.setTextColor(typePokemonColor)
            binding.attackText.setTextColor(typePokemonColor)
            binding.statAttack.progressTintList = ColorStateList.valueOf(typePokemonColor)
            binding.defText.setTextColor(typePokemonColor)
            binding.statDefense.progressTintList = ColorStateList.valueOf(typePokemonColor)
            binding.sAttText.setTextColor(typePokemonColor)
            binding.statSpeAttack.progressTintList = ColorStateList.valueOf(typePokemonColor)
            binding.sDefText.setTextColor(typePokemonColor)
            binding.statSpeDefense.progressTintList = ColorStateList.valueOf(typePokemonColor)
            binding.speedText.setTextColor(typePokemonColor)
            binding.statSpeed.progressTintList = ColorStateList.valueOf(typePokemonColor)
        }

         //getColor(R.color.Poison)

        setContentView(binding.root)
    }
}

//@+id/description max size 100 characters