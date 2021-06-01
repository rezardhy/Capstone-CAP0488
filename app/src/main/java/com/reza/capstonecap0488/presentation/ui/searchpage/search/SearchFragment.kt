package com.reza.capstonecap0488.presentation.ui.searchpage.search

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.reza.capstonecap0488.databinding.FragmentSearchBinding
import com.reza.capstonecap0488.presentation.ui.searchpage.camera.CameraActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.gallery.GalleryActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.identification.IdentificationActivity
import java.io.ByteArrayOutputStream

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


        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED){
            val i  = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, IMAGE_CAMERA)

        }
        else{
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA),
                CAMERA_REQ)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_REQ){
            if(grantResults.isNotEmpty()&& grantResults[0] ==  PackageManager.PERMISSION_GRANTED){
                val i  = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(i, IMAGE_CAMERA)
            }
        }

    }

    companion object{
        val IMAGE_REQUEST_CODE =100
        val IMAGE_CAMERA = 0
        val CAMERA_REQ = 2

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val uriFoto = data?.data
            moveToIdentification(uriFoto.toString())
        }
        else if (requestCode == IMAGE_CAMERA && resultCode == Activity.RESULT_OK){
            var bmp = data?.extras?.get("data") as Bitmap
            val uri = getImageUriFromBitmap(requireContext(),bmp)
            moveToIdentification(uri.toString())
        }
    }


    fun getImageUriFromBitmap(context: Context, bitmap: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null)
        return Uri.parse(path.toString())
    }

    private fun moveToIdentification(uriFoto : String){
        val i = Intent(activity, IdentificationActivity::class.java)
        i.putExtra(IdentificationActivity.EXTRAFOTO,uriFoto)
        startActivity(i)
    }

}