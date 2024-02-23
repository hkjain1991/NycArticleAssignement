package com.example.nycarticlesassignment.model.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for Article
 * @author hemeandra jain
 */
data class Article(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("num_results") val numResults: Int,
    @SerializedName("results") val results: List<ArticleMetaData>
)