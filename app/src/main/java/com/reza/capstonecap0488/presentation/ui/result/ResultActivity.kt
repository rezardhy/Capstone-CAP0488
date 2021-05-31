package com.reza.capstonecap0488.presentation.ui.result

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.google.firebase.firestore.FirebaseFirestore
import com.reza.capstonecap0488.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    var db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        title = "Tomat"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val img  = intent.getStringExtra("uri")
        binding.imgResult.setImageURI(img?.toUri())
        cekFireStore()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun cekFireStore(){
        val docRef = db.collection("penyakit_tomat").document("Layu Bakteri")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("berhasil", "Succes")

                    binding.namaPenyakit.text = document.getString("nama")
                } else {
                    Log.d("kosong", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("gagal", "get failed with ", exception)
            }
    }

    companion object{
        const val EXTRA = "uri"
    }
}