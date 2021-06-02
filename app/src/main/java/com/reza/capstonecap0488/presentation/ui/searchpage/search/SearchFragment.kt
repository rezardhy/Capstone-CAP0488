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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.reza.capstonecap0488.databinding.FragmentSearchBinding
import com.reza.capstonecap0488.presentation.ui.searchpage.identification.IdentificationActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.image.ImageActivity
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

        binding.cvTomat.setOnClickListener{
            val i = Intent(activity,ImageActivity::class.java)
            i.putExtra(ImageActivity.EXTRAJENIS,"Tomat")
            startActivity(i)
        }

        binding.cvTester.setOnClickListener{
            val i = Intent(activity,ImageActivity::class.java)
            i.putExtra(ImageActivity.EXTRAJENIS,"mobile net")
            startActivity(i)
        }



    }



}