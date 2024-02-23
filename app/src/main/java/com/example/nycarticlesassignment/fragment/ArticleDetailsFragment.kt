package com.example.nycarticlesassignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.nycarticlesassignment.R
import com.example.nycarticlesassignment.databinding.FragmentArticleDetailsBinding
import com.example.nycarticlesassignment.viewmodel.ArticleListDetailsViewModel

/**
 * Fragment for showing articles detail
 * @author hemeandra jain
 */
class ArticleDetailsFragment : Fragment() {

    private lateinit var fragmentArticleDetailsBinding: FragmentArticleDetailsBinding
    private val articleListDetailsViewModel: ArticleListDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback {
            articleListDetailsViewModel.setSelectedArticle(null)
            findNavController().navigate(R.id.action_articleDetailsFragment_to_articleListFragment2)
        }
        setupObservers()
        fragmentArticleDetailsBinding = FragmentArticleDetailsBinding.inflate(
            inflater, container, false
        )
        return fragmentArticleDetailsBinding.root
    }

    /**
     * Sets the observer for Live data
     */
    private fun setupObservers() {
        articleListDetailsViewModel.articleDetailsLiveData.observe(viewLifecycleOwner) {
            it?.let {

                if (
                    it.articleMedia.isNotEmpty() && it.articleMedia[0].articleMediaMetadata.isNotEmpty()
                ) {
                    Glide.with(requireContext())
                        .load(it.articleMedia[0].articleMediaMetadata[0].url!!)
                        .into(fragmentArticleDetailsBinding.imgStock)
                }

                fragmentArticleDetailsBinding.txtTitle.text = it.title
                fragmentArticleDetailsBinding.txtDescription.text = it.abstract
            }
        }
    }
}