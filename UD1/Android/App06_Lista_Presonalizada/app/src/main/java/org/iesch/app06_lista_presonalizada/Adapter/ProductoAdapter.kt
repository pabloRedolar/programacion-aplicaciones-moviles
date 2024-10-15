package org.iesch.app06_lista_presonalizada.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.iesch.app06_lista_presonalizada.Model.Producto
import org.iesch.app06_lista_presonalizada.R

class ProductoAdapter(private val mContext: Context, private val listaProducto: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProducto) {
    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProducto[position]

        layout.findViewById<TextView>(R.id.tvTitulo).text = producto.nombre
        layout.findViewById<TextView>(R.id.tvPrecio).text = producto.precio.toString() + " €"
        layout.findViewById<ImageView>(R.id.imageView).setImageResource(producto.imagen)

        return layout
    }
}