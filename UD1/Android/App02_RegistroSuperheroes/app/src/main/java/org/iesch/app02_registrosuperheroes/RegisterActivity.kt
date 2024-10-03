package org.iesch.app02_registrosuperheroes

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app02_registrosuperheroes.databinding.ActivityRegisterBinding
import org.iesch.app02_registrosuperheroes.model.Hero

class RegisterActivity : AppCompatActivity() {

    companion object {
        const val HERO_NAME_KEY = "heroName"
        const val ALTER_EGO_KEY = "alter_ego"
        const val BIO = "bio"
        const val POWER = "power"
        const val HERO_KEY = "hero"
        const val FOTO_KEY = "foto"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 9 - Binding

        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 10 - Nos creamos una variable bundle que recoge todos los valores traídos

        val bundle: Bundle = intent.extras!!

        val superHero = bundle.getParcelable<Hero>(HERO_KEY)!!
        val bitmap = bundle.getParcelable<Bitmap>(FOTO_KEY)!!

        // 12 - Los mostramos en pantalla

        binding.heroNameRegister.text = superHero.name
        binding.alterEgoRegister.text = superHero.alterEgo
        binding.bioEditRegister.text = superHero.bio
        binding.ratingBarRegister.rating = superHero.power
        binding.imageView.setImageBitmap(bitmap)

    }
}