package com.example.nycarticlesassignment.model.response

import com.example.weatherapp.Results
import com.google.gson.annotations.SerializedName


data class Article(
    @SerializedName("status") var status: String,
    @SerializedName("copyright") var copyright: String,
    @SerializedName("num_results") var numResults: Int,
    @SerializedName("results") var results: ArrayList<Results>
)