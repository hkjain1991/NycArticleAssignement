package com.example.nycarticlesassignment.retrofit

import com.example.nycarticlesassignment.model.response.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesApi {

    @GET("/svc/mostpopular/v2/viewed/1.json")
    suspend fun getArticles(@Query("api-key") apiKey: String): Response<Article>
}