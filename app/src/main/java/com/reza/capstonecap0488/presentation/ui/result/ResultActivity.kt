package com.reza.capstonecap0488.presentation.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        title = "Tomat"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val img  = intent.getStringExtra("uri")
        binding.imgResult.setImageURI(img?.toUri())

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    companion object{
        const val EXTRA = "uri"
    }
}