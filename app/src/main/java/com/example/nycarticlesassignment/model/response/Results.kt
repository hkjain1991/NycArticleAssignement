package com.example.weatherapp

import com.google.gson.annotations.SerializedName


data class Results(
    @SerializedName("uri") var uri: String,
    @SerializedName("url") var url: String,
    @SerializedName("id") var id: String,
    @SerializedName("asset_id") var assetId: String,
    @SerializedName("source") var source: String,
    @SerializedName("published_date") var publishedDate: String,
    @SerializedName("updated") var updated: String,
    @SerializedName("section") var section: String,
    @SerializedName("subsection") var subsection: String,
    @SerializedName("nytdsection") var nytdsection: String,
    @SerializedName("adx_keywords") var adxKeywords: String,
    @SerializedName("column") var column: String,
    @SerializedName("byline") var byline: String,
    @SerializedName("type") var type: String,
    @SerializedName("title") var title: String,
    @SerializedName("abstract") var abstract: String,
    @SerializedName("des_facet") var desFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("org_facet") var orgFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("per_facet") var perFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("geo_facet") var geoFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("media") var media: ArrayList<Media> = arrayListOf(),
    @SerializedName("eta_id") var etaId: Int

)