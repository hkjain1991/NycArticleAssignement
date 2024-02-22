package com.example.nycarticlesassignment.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycarticlesassignment.enum.ArticleScreenError
import com.example.nycarticlesassignment.repository.RemoteRepository
import com.example.nycarticlesassignment.utils.InternetConnection
import com.example.weatherapp.Results
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleListDetailsViewModel : ViewModel() {
    private val _articleListLiveData: MutableLiveData<List<Results>?> =
        MutableLiveData<List<Results>?>()

    val articleListLiveData: LiveData<List<Results>?> = _articleListLiveData

    private val _articleDetailsLiveData: MutableLiveData<Results?> =
        MutableLiveData<Results?>()

    val articleDetailsLiveData: LiveData<Results?> = _articleDetailsLiveData

    private val _error: MutableLiveData<ArticleScreenError?> =
        MutableLiveData<ArticleScreenError?>()

    val error: LiveData<ArticleScreenError?> = _error

    fun setSelectedArticle(results: Results?) {
        _articleDetailsLiveData.value = results
    }

    fun getLatestArticlesList(context: Context) {
        if (!InternetConnection.isNetworkAvailable(context)) {
            _error.value = ArticleScreenError.INTERNET_NOT_AVAILABLE
        } else {
            callArticleListApi()
        }
    }

    private fun callArticleListApi(
        remoteRepository: RemoteRepository = RemoteRepository(),
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            remoteRepository.getArticles()?.let {
                _articleListLiveData.postValue(it.results)
                _error.postValue(null)
            } ?: kotlin.run {
                _articleListLiveData.postValue(null)
                _error.postValue(ArticleScreenError.RESULTS_NOT_AVAILABLE)
            }
        }

    }
}