package com.reza.capstonecap0488.presentation.ui.searchpage.identification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.reza.capstonecap0488.databinding.ActivityIdentificationBinding
import com.reza.capstonecap0488.presentation.ui.searchpage.result.ResultActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.suggestion.SuggestionActivity

class IdentificationActivity : AppCompatActivity() {
    private lateinit var binding :ActivityIdentificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foto = intent.getStringExtra("extrafoto")
        Log.d("cekd",foto.toString())
        binding.foto.setImageURI(foto?.toUri())

        binding.buttonIdentifikasi.setOnClickListener {
            val i = Intent(this, SuggestionActivity::class.java)
            i.putExtra(SuggestionActivity.EXTRA,foto)
            startActivity(i)
            finish()
        }

    }

    companion object{
        val EXTRAFOTO = "extrafoto"
    }
}