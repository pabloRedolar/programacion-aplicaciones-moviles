package org.iesch.a07_recyclerview_rock

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.iesch.a07_recyclerview_rock.adapter.AlbumAdapter
import org.iesch.a07_recyclerview_rock.databinding.ActivityMainBinding
import org.iesch.a07_recyclerview_rock.model.Album
import org.iesch.a07_recyclerview_rock.provider.AlbumProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val layout = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, layout.orientation)

        binding.recyclerAlbum.layoutManager = LinearLayoutManager(this)
        // El activity necestita un parametro para el onclicklistener (la lambda)
        binding.recyclerAlbum.adapter = AlbumAdapter(AlbumProvider.listaDeAlbums, { album ->
            onItemSelected(album)
        })
        binding.recyclerAlbum.addItemDecoration(decoration)
    }

    fun onItemSelected(album: Album) {
        Toast.makeText(this, album.anno, Toast.LENGTH_SHORT).show()
    }

}