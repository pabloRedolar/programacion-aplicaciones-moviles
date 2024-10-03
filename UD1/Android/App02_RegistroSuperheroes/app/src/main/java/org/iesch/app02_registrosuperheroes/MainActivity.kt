package org.iesch.app02_registrosuperheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.app02_registrosuperheroes.databinding.ActivityMainBinding
import org.iesch.app02_registrosuperheroes.model.Hero
import java.io.File

class MainActivity : AppCompatActivity() {
    private val CAMERA_KEY = 1000
    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null

    private var pictureFullPath = ""

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        // Devuelve un boleano, si se toma la foto devuelve un correcto
        succes ->
        if (succes && pictureFullPath.isNotEmpty()){
            heroBitmap = BitmapFactory.decodeFile(pictureFullPath)
            heroImage.setImageBitmap(heroBitmap!!)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heroImage = binding.supeheroImg
        heroImage.setOnClickListener() {
            openCamera()
        }

        binding.saveButton.setOnClickListener {
            val superHeroName = binding.heronameMain.text.toString()
            val alterEgo = binding.alteregoMain.text.toString()
            val bio = binding.bioEditMain.text.toString()
            val power = binding.powerBarMain.rating

            val hero = Hero(superHeroName, alterEgo, bio, power)
            openDetailActivity(hero)
        }
    }

    private fun openCamera() {
        val imageFile = createImageFile()
        val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            
        }
    }

    private fun createImageFile(): File {
        val fileName = "superhero_image"
        // Directorio donde se guarda la imagen. Directorio pictures por defecto
        val fileDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        //Creamos nuestro archivo, pide el nombre el formato y el dir

        val file =  File.createTempFile(fileName, ".jpg", fileDirectory)
        pictureFullPath = file.absolutePath
        return file
    }

    private fun openDetailActivity(hero: Hero) {
        val intent = Intent(this, RegisterActivity::class.java)
        intent.putExtra(RegisterActivity.HERO_KEY, hero)
        intent.putExtra(RegisterActivity.FOTO_KEY, heroImage.drawable.toBitmap())

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_KEY) {
            val extras = data?.extras
            val heroBitmap = extras?.getParcelable<Bitmap>("data")

            heroImage.setImageBitmap(heroBitmap)
        }
    }
}