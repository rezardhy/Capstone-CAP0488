package com.reza.capstonecap0488.presentation.ui.searchpage.camera

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.reza.capstonecap0488.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var foto = intent.getStringExtra("bm")
        Log.d("cekbm",foto.toString())
        binding.fotoCamera.setImageURI(foto?.toUri())


    }

    companion object{
        const val EXTRABM = "bm"
    }
}