package org.iesch.app06_lista_presonalizada

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app06_lista_presonalizada.Adapter.ProductoAdapter
import org.iesch.app06_lista_presonalizada.Model.Producto
import org.iesch.app06_lista_presonalizada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val producto = Producto("Camara de fotos", 100.0, "Camara de epson mu nueva", R.drawable.camara)
        val producto1 = Producto("Pixel 8 pro", 600.0, "Movil mu bueno", R.drawable.movil)

        val listaProductos = listOf<Producto>(producto, producto1)

        val customAdapter = ProductoAdapter(this, listaProductos)

        binding.listaProductos.adapter = customAdapter

    }
}