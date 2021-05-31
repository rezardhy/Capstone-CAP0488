package com.reza.capstonecap0488.presentation.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.capstonecap0488.databinding.LayoutRecycleviewBinding
import com.reza.capstonecap0488.domain.ArticleModel
import com.reza.capstonecap0488.presentation.ui.article.ArticleActivity

class HomeAdapter():RecyclerView.Adapter<HomeAdapter.ArticleViewHolder>() {


    private var mlist = ArrayList<ArticleModel>()
    fun setArticle(list: List<ArticleModel>?) {
        if (list == null) return
        this.mlist.clear()
        this.mlist.addAll(list)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding =LayoutRecycleviewBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = mlist[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = mlist.size

    inner class ArticleViewHolder(private val binding:LayoutRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.apply {
                tvArticle.text = article.title

                Glide.with(itemView.context)
                    .load(article.img)
                    .into(binding.ivArticle)

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, ArticleActivity::class.java)
                    i.putExtra(ArticleActivity.EXTRA,article)
                    itemView.context.startActivity(i)

                }

            }


        }


    }


}