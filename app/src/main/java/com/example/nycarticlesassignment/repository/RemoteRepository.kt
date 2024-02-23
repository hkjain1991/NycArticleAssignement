package com.example.nycarticlesassignment.repository

import com.example.nycarticlesassignment.model.response.Article
import com.example.nycarticlesassignment.retrofit.APIClient
import com.example.nycarticlesassignment.retrofit.ArticlesApi
import com.example.nycarticlesassignment.utils.Constants
import retrofit2.Response
import retrofit2.http.Query

/**
 * Repository to get data from server
 * @author hemeandra jain
 */
class RemoteRepository {
    /**
     * Method to get [Article] from server. If Server will give error, then method will return null
     * @return [Article]
     */
    suspend fun getArticles(): Article? {
        val articlesApi = APIClient.getInstance().create(ArticlesApi::class.java)
        return articlesApi.getArticles(
            Constants.APP_ID
        ).body()
    }
}