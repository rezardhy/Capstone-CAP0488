package com.reza.capstonecap0488.presentation.ui.result

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.google.firebase.firestore.FirebaseFirestore
import com.reza.capstonecap0488.databinding.ActivityResultBinding
import com.reza.capstonecap0488.domain.SuggestionModel


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        setResult()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun setResult(){
        val isi = intent.getParcelableExtra<SuggestionModel>("extra") as SuggestionModel
        binding.penyakit.text = isi.nama
        binding.penjelasanPenyakit.text = isi.penyebab
        binding.solusiPenyakit.text = isi.solusi

    }


    companion object{
        const val EXTRA = "extra"
    }
}