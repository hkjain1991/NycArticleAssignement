package com.example.nycarticlesassignment.model.response

import com.google.gson.annotations.SerializedName

/**
 * Data class for Article Media
 * @author hemeandra jain
 */
data class ArticleMedia(
    @SerializedName("type") val type: String? = null,
    @SerializedName("subtype") val subtype: String? = null,
    @SerializedName("caption") val caption: String? = null,
    @SerializedName("copyright") val copyright: String? = null,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Int? = null,
    @SerializedName("media-metadata") val articleMediaMetadata: ArrayList<ArticleMediaMetaData> = arrayListOf()
)