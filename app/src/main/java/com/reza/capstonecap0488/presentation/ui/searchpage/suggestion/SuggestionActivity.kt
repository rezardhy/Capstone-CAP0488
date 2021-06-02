package com.reza.capstonecap0488.presentation.ui.searchpage.suggestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.reza.capstonecap0488.databinding.ActivitySuggestionBinding
import com.reza.capstonecap0488.domain.SuggestionModel

class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding
    private var db = FirebaseFirestore.getInstance()
    private var mlist = ArrayList<SuggestionModel>()
    private val suggestionAdapter = SuggestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hasil = intent.getStringExtra("hasil")
        binding.tvHasil.text = hasil
        val img  = intent.getStringExtra("uri")
        binding.ivUri.setImageURI(img?.toUri())
        binding.progresBar.visibility = View.GONE

        //cekFireStore()


    }
    /*
    private fun cekFireStore(){
        val docRef = db.collection("penyakit_tomat")
        docRef.get()
                .addOnSuccessListener { documents ->
                    if (documents != null) {
                        for (document in documents) {
                            Log.d("berhasil", "${document.id} => ${document.data}")
                            mlist.add(SuggestionModel(
                                    document.getString("nama").toString(),
                                    document.getString("penjelasan").toString(),
                                    document.getString("solusi").toString()

                                    )
                            )

                        }

                        Log.d("berhasilmlist",mlist.toString())
                        suggestionAdapter.setSuggestion(mlist)
                        showList()
                    } else {
                        Log.d("kosong", "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("gagal", "get failed with ", exception)
                }
        Log.d("cekmlist", mlist.toString())



    }
*/

    /*private fun showList(){
        binding.progresBar.visibility = View.GONE
        with(binding.rvArticle){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = suggestionAdapter
        }
    }*/

    companion object{
        const val EXTRA = "uri"
        const val HASIL = "hasil"
    }

}