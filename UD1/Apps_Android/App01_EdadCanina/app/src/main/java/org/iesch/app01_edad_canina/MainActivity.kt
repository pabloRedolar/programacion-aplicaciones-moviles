package org.iesch.app01_edad_canina

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app01_edad_canina.databinding.ActivityMainBinding

// paso 3 - Añadimos data binding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val resulText = findViewById<TextView>(R.id.tvRespuesta)
//        val calculateButton = findViewById<Button>(R.id.btnCalcular)
//        val ageEdit = findViewById<EditText>(R.id.etEdad)


        binding.btnCalcular.setOnClickListener {
            val ageString = binding.etEdad.text.toString()

            if (ageString.isEmpty()) {
//              Log.i("Error numero", "No has introducido ningun numero")
                Toast.makeText(this, "Debes meter un valor numero entre 1 y 150", Toast.LENGTH_LONG)
                    .show()
            } else {
                val ageInt = ageString.toInt()
                val dogAge = ageInt * 7
                //resulText.text = "Si fueras perro tendrias $dogAge"
                binding.tvRespuesta.text = getString(R.string.resultado, dogAge)

            }
        }
    }
}