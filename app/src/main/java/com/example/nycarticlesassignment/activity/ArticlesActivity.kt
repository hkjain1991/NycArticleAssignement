package com.example.nycarticlesassignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.nycarticlesassignment.R
import com.example.nycarticlesassignment.viewmodel.ArticleListDetailsViewModel

class ArticlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }
}