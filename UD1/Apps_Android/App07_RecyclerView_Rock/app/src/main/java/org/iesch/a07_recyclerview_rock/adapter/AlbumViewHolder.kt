package org.iesch.a07_recyclerview_rock.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.a07_recyclerview_rock.databinding.ItemAlbumBinding
import org.iesch.a07_recyclerview_rock.model.Album

class AlbumViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemAlbumBinding.bind(view)

    fun render(albumModel: Album, onClickListener: (Album) -> Unit) {
        binding.tvTitulo.text = albumModel.titulo
        binding.tvAnno.text = albumModel.anno.toString()
        binding.tvAutor.text = albumModel.autor

        Glide.with(binding.imgAlbum.context).load(albumModel.portada).into(binding.imgAlbum)

        itemView.setOnClickListener {
            onClickListener(albumModel)
        }

//        binding.imgAlbum.setOnClickListener {
//            Toast.makeText(binding.imgAlbum.context, albumModel.autor, Toast.LENGTH_SHORT).show()
//        }
//
//        itemView.setOnClickListener {
//            Toast.makeText(binding.imgAlbum.context, albumModel.titulo, Toast.LENGTH_SHORT).show()
//        }


    }

}