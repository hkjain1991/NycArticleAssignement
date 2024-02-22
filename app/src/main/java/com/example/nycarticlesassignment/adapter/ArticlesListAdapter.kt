package com.example.nycarticlesassignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nycarticlesassignment.databinding.ItemArticleDetailsBinding
import com.example.nycarticlesassignment.model.response.ArticleMetaData

class ArticlesListAdapter(
    private var articleList: List<ArticleMetaData>,
    private val callback: (ArticleMetaData) -> Unit
) :
    RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

    private lateinit var itemArticleDetailsBinding: ItemArticleDetailsBinding

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(binding: ItemArticleDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView
        val author: TextView
        val date: TextView

        init {
            title = binding.txtTitle
            author = binding.txtAuthor
            date = binding.txtDate
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        itemArticleDetailsBinding = ItemArticleDetailsBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(itemArticleDetailsBinding)
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val article = articleList[position]
        viewHolder.title.text = article.title
        viewHolder.author.text = article.byline
        viewHolder.date.text = article.publishedDate
        viewHolder.itemView.setOnClickListener {
            callback(article)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(articles: List<ArticleMetaData>) {
        this.articleList = articles
        notifyDataSetChanged()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articleList.size
}