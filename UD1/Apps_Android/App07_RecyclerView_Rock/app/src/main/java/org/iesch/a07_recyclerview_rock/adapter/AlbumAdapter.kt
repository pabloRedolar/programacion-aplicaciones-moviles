package org.iesch.a07_recyclerview_rock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.iesch.a07_recyclerview_rock.R
import org.iesch.a07_recyclerview_rock.model.Album


class AlbumAdapter(
    private var listaDeAlbums: List<Album>,
    private val onClickListener: (Album) -> Unit) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        //Aqui le pasamos el layout q vamos a modificar
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlbumViewHolder(layoutInflater.inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        //Este metodo me pide le numero de elementos que va a tener el recycler
        return listaDeAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = listaDeAlbums[position]

        holder.render(item, onClickListener)
    }
}