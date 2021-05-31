package com.reza.capstonecap0488.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.data.ArticleDummy
import com.reza.capstonecap0488.databinding.FragmentHomeBinding
import com.reza.capstonecap0488.presentation.ui.article.ArticleActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding:FragmentHomeBinding
    private val homeAdapter = HomeAdapter()

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
        homeAdapter.setArticle(ArticleDummy.generateArticle())
        homeAdapter.notifyDataSetChanged()
        showList()

    }

    private fun showList(){
        with(binding.rvArticle){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

}