package org.iesch.app02_registrosuperheroes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app02_registrosuperheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 1 - Añadimos binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 2 - Le damos funcionalidad al boton
        binding.saveButton.setOnClickListener {
            // 6 - Nos creamos la variables necesarias para pasarlas al intent
            val superHeroname = binding.etHeroname.text.toString()
            val alterEgo = binding.alterego.text.toString()
            val bioPuta = binding.bioEdit.text.toString()
            val power = binding.powerBar.rating
            openDetailActivity(superHeroname, alterEgo, bioPuta, power)

            openDetailActivity()
        }
    }

    // 3 - Creamos la funcion que genera un Intent y nos lleva a detalle
    private fun openDetailActivity(superheroName: String, alterEgo: String, bio: String, power: Float) {
        // 4 - vamos a abrir DetailActivity. El intent debe tener muy claro desde donde se le llama y a donde va

        val intent = Intent(this, RegisterActivity::class.java)

        intent.putExtra("heroname", superheroName)
        intent.putExtra("alter_ego", alterEgo)
        intent.putExtra("bio", bio)
        intent.putExtra("power", power)
        // 5 - Para utilizar el intent tenemos que llamar a startActivity
        startActivity(intent)

    }
}