package com.example.nycarticlesassignment.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nycarticlesassignment.R

/**
 * Activity for showing views for article list and details
 * @author hemeandra jain
 */
class ArticlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
    }
}