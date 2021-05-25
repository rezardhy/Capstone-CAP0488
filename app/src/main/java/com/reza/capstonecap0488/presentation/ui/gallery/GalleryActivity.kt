package com.reza.capstonecap0488.presentation.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.ActivityGalleryBinding
import com.reza.capstonecap0488.presentation.ui.result.ResultActivity

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foto = intent.getStringExtra("extrafoto")
        Log.d("cekd",foto.toString())
        binding.fotoGaleri.setImageURI(foto?.toUri())

        binding.buttonIdentifikasi.setOnClickListener {
            val i = Intent(this,ResultActivity::class.java)
            i.putExtra(ResultActivity.EXTRA,foto)
            startActivity(i)
            finish()
        }



    }

    companion object{
        val EXTRAFOTO = "extrafoto"
    }
}