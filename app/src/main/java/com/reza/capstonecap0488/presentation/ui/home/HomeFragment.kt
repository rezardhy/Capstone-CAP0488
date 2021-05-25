package com.reza.capstonecap0488.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.FragmentHomeBinding
import com.reza.capstonecap0488.presentation.ui.article.ArticleActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rl1.setOnClickListener {
            val i = Intent(activity,ArticleActivity::class.java)
            startActivity(i)
        }
    }
}