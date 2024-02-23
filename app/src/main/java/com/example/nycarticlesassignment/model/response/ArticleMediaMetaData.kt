package com.example.nycarticlesassignment.model.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for Article Media Meta Data like url
 * @author hemeandra jain
 */
data class ArticleMediaMetaData(
    @SerializedName("url") val url: String,
    @SerializedName("format") val format: String,
    @SerializedName("height") val height: Int,
    @SerializedName("width") val width: Int
)