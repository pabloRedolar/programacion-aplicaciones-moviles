package org.iesch.app05_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app05_listview.databinding.ActivityMainBinding
import org.intellij.lang.annotations.Flow

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1 - Creamos un ArrayAdapter para trabajar con los elementos de nuestro ListView
        val arrayAdapter : ArrayAdapter<*>

        // 2 - Voy a usar una lista mutable, y coloco los elementos
        val versiones = mutableListOf("Pie", "Oreo", "Nougat", "Marshmallow", "Lollipop", "Tiramisu", "Kitkat", "Ice Cream", "...")

        // 3 - Declaro la variable que va a llamar de forma grafica a mi listView
        val lViewDatos = binding.listaVersiones

        // 4 - para llevar de datos la lista creamos un arrayAdapter, que es un objeto de tipo arrayAdapter
        // Me pide: Contexto, como mostrar los datos por pantalla (ahora uso una generica de Android), y los datos a mostrar
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, versiones)

        // 5 - LLamo al lviewdatos de datos, el adaptador traera toda la informacion del arrayList, lo adaptara a nuestra lista
        lViewDatos.adapter = arrayAdapter

        lViewDatos.setOnItemClickListener {adapterView, view, position, id ->
            //adapterView es el elemento visual donde estan los datos
            //view es la vista
            //position es la posision de cada elemento
            //id es el index de cada elemento

            Toast.makeText(this, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
        }
    }


}