package com.example.nycarticlesassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nycarticlesassignment.R
import com.example.nycarticlesassignment.viewmodel.ArticleListDetailsViewModel

class ArticleDetailsFragment : Fragment() {

    private val articleListDetailsViewModel: ArticleListDetailsViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback {
            articleListDetailsViewModel.setSelectedArticle(null)
            findNavController().navigate(R.id.action_articleDetailsFragment_to_articleListFragment2)
        }
        setupObservers()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_details, container, false)
    }

    private fun setupObservers() {
        articleListDetailsViewModel.articleDetailsLiveData.observe(viewLifecycleOwner) {
            // set on UI
        }
    }
}