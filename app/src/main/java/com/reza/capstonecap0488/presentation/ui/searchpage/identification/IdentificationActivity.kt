package com.reza.capstonecap0488.presentation.ui.searchpage.identification

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.net.toUri
import com.reza.capstonecap0488.databinding.ActivityIdentificationBinding
import com.reza.capstonecap0488.ml.MobilenetV110224Quant
import com.reza.capstonecap0488.ml.ModelTomat
import com.reza.capstonecap0488.presentation.ui.searchpage.result.ResultActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.suggestion.SuggestionActivity
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class IdentificationActivity : AppCompatActivity() {

    private lateinit var binding :ActivityIdentificationBinding
    private lateinit var titleJenis:String
    lateinit var bitmap: Bitmap
    private lateinit var filename:String
    private lateinit var inputString:String
    private lateinit var townList : List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdentificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foto = intent.getStringExtra("extrafoto")
        binding.foto.setImageURI(foto?.toUri())
        titleJenis = intent.getStringExtra("extrajenis").toString()
        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,foto?.toUri())
        title = titleJenis


        //access label
        if (titleJenis == "tomat"){

            filename = "labeltomat.txt"
            inputString = application.assets.open(filename).bufferedReader().use { it.readText() }
            townList = inputString.split("\n")

        }
        else if(titleJenis =="mobilenet"){
            filename = "labelmobilenet.txt"
            inputString = application.assets.open(filename).bufferedReader().use { it.readText() }
            townList = inputString.split("\n")
        }



        binding.buttonIdentifikasi.setOnClickListener {


            Log.d("cektitle",titleJenis)


            if(titleJenis == "tomat"){
                val hasil = tomatModel()
                Log.d("hasil","hasil")
                val i = Intent(this, SuggestionActivity::class.java)
                i.putExtra(SuggestionActivity.EXTRA,foto)
                i.putExtra(SuggestionActivity.HASIL,hasil)
                startActivity(i)
                //finish()

            }
            else if(titleJenis == "mobilenet"){
                val hasil = mobilenetModel()
                Log.d("hasil","hasil")
                val i = Intent(this, SuggestionActivity::class.java)
                i.putExtra(SuggestionActivity.EXTRA,foto)
                i.putExtra(SuggestionActivity.HASIL,hasil)
                startActivity(i)
                //finish()
            }

        }

    }

    private fun tomatModel():String{
        var resized = Bitmap.createScaledBitmap(bitmap,150, 150, true)
        val model = ModelTomat.newInstance(this)
        var tbuffer = TensorImage.fromBitmap(resized)
        var byteBuffer = tbuffer.buffer

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 150, 150, 3), DataType.UINT8)
        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        var max = getMax(outputFeature0)
        var hasil = townList[max]
        Log.d("hasil",hasil)
        //binding.tvHasil.text = hasil

        model.close()

        return hasil

    }

    private fun mobilenetModel():String{
        var resized = Bitmap.createScaledBitmap(bitmap,224, 224, true)
        val model = MobilenetV110224Quant.newInstance(this)
        var tbuffer = TensorImage.fromBitmap(resized)
        var byteBuffer = tbuffer.buffer

        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.UINT8)
        Log.d("cek123",inputFeature0.toString())
        inputFeature0.loadBuffer(byteBuffer)

        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        var max = getMax(outputFeature0)
        var hasil = townList[max]
        Log.d("hasil",hasil)
        //binding.tvHasil.text = hasil

        model.close()

        return hasil

    }

    fun getMax(arr:FloatArray):Int{

        var max = 0

        if(titleJenis == "tomat")
            max = 9
        else if(titleJenis == "mobilenet")
            max = 1000

        var ind = 0
        var min = 0.0f
        for (i in 0..max){
            if (arr[i]>min){
                ind = i
                min = arr[i]
            }
        }

        return ind
    }

    companion object{
        const val EXTRAFOTO = "extrafoto"
        const val EXTRAJENIS = "extrajenis"
    }
}