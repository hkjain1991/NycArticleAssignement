package com.example.nycarticlesassignment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nycarticlesassignment.adapter.ArticlesListAdapter
import com.example.nycarticlesassignment.enum.ArticleScreenError
import com.example.nycarticlesassignment.model.response.Article
import com.example.nycarticlesassignment.model.response.ArticleMetaData
import com.example.nycarticlesassignment.repository.RemoteRepository
import com.example.nycarticlesassignment.viewmodel.ArticleListDetailsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Tests for [ArticleListDetailsViewModel]
 * @author Hemeandra Jain on 23-02-2024
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ArticleListDetailsViewModelTest {
    private lateinit var viewModel: ArticleListDetailsViewModel
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = ArticleListDetailsViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test to verify tht article data has got success`() = runTest {
        val mock = mockk<RemoteRepository>()
        coEvery {
            mock.getArticles()
        } returns Article("True", "by Yash", 20, emptyList())
        viewModel.callArticleListApi(mock, dispatcher)

        Assert.assertEquals(viewModel.articleListLiveData.value?.isEmpty(), true)
        Assert.assertNull(viewModel.error.value)
    }

    @Test
    fun `test to verify tht article data has got error`() = runTest {
        val mock = mockk<RemoteRepository>()
        coEvery {
            mock.getArticles()
        } returns null
        viewModel.callArticleListApi(mock, dispatcher)

        Assert.assertNull(viewModel.articleListLiveData.value)
        Assert.assertEquals(viewModel.error.value, ArticleScreenError.RESULTS_NOT_AVAILABLE)
    }
}