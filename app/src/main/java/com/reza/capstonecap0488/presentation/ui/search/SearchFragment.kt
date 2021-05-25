package com.reza.capstonecap0488.presentation.ui.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.reza.capstonecap0488.databinding.FragmentSearchBinding
import com.reza.capstonecap0488.presentation.ui.gallery.GalleryActivity

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        binding.buttonGallery.setOnClickListener{
           takeFromGallery()
        }
        binding.buttonCamera.setOnClickListener {
            openCamera()
        }
    }

    private fun takeFromGallery(){
        val i  = Intent(Intent.ACTION_PICK)
        i.type = "image/*"
        startActivityForResult(i, IMAGE_REQUEST_CODE)
    }

    private fun openCamera(){
        val i  = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        startActivityForResult(i, IMAGE_CAMERA)

    }

    companion object{
        val IMAGE_REQUEST_CODE =100
        val IMAGE_CAMERA = 111
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val uriFoto = data?.data
            moveActivity(uriFoto.toString())
        }
        else if (requestCode == IMAGE_CAMERA && resultCode == Activity.RESULT_OK){
            //var bmp = data?.extras?.get("data") as Bitmap
        }
    }

    private fun moveActivity(uriFoto : String){
        val i = Intent(activity,GalleryActivity::class.java)
        i.putExtra(GalleryActivity.EXTRAFOTO,uriFoto)
        startActivity(i)
    }
}