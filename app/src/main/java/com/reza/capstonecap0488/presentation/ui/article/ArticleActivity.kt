package com.reza.capstonecap0488.presentation.ui.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reza.capstonecap0488.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        title = "Article"
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}