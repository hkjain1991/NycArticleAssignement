package com.example.nycarticlesassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nycarticlesassignment.R
import com.example.nycarticlesassignment.adapter.ArticlesListAdapter
import com.example.nycarticlesassignment.databinding.FragmentArticleListBinding
import com.example.nycarticlesassignment.enum.ArticleScreenError
import com.example.nycarticlesassignment.viewmodel.ArticleListDetailsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleListFragment : Fragment() {

    private lateinit var fragmentArticleListBinding: FragmentArticleListBinding
    private val articleListDetailsViewModel: ArticleListDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentArticleListBinding = FragmentArticleListBinding.inflate(
            inflater, container, false
        )
        articleListDetailsViewModel.getLatestArticlesList(requireContext())
        setObservers()
        return fragmentArticleListBinding.root
    }

    override fun onStart() {
        super.onStart()
        fragmentArticleListBinding.proBar.visibility = View.VISIBLE
    }

    private fun setObservers() {
        val recyclerView: RecyclerView = fragmentArticleListBinding.articles
        val customAdapter = ArticlesListAdapter(emptyList()) {
            articleListDetailsViewModel.setSelectedArticle(it)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = customAdapter
        articleListDetailsViewModel.articleListLiveData.observe(viewLifecycleOwner) { list ->
            fragmentArticleListBinding.proBar.visibility = View.GONE
            list?.let {
                recyclerView.visibility = View.VISIBLE
                customAdapter.updateList(it)
            } ?: kotlin.run {
                recyclerView.visibility = View.GONE
            }
        }
        articleListDetailsViewModel.error.observe(viewLifecycleOwner) {
            fragmentArticleListBinding.articles.visibility = View.GONE
            fragmentArticleListBinding.proBar.visibility = View.GONE
            when (it) {
                ArticleScreenError.INTERNET_NOT_AVAILABLE -> Toast.makeText(
                    requireContext(),
                    R.string.internet_connection_error,
                    Toast.LENGTH_SHORT
                ).show()

                ArticleScreenError.RESULTS_NOT_AVAILABLE -> Toast.makeText(
                    requireContext(),
                    R.string.articles_not_available,
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    fragmentArticleListBinding.articles.visibility = View.VISIBLE
                }
            }
        }
        articleListDetailsViewModel.articleDetailsLiveData.observe(viewLifecycleOwner) {
            it?.let {
                findNavController().navigate(R.id.action_articleListFragment_to_articleDetailsFragment)
            } ?: kotlin.run {
                // No action required
            }
        }
    }

}