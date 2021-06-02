package com.reza.capstonecap0488.presentation.ui.searchpage.search

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.LayoutRecycleviewSmallBinding
import com.reza.capstonecap0488.domain.PlantTypeModel
import com.reza.capstonecap0488.domain.SuggestionModel
import com.reza.capstonecap0488.presentation.ui.searchpage.image.ImageActivity
import com.reza.capstonecap0488.presentation.ui.searchpage.result.ResultActivity

class SearchAdapter():RecyclerView.Adapter<SearchAdapter.SearchiewHolder>() {

    private var mlist = ArrayList<PlantTypeModel>()
    fun setSearchPlant(list: List<PlantTypeModel>?) {
        if (list == null) return
        this.mlist.clear()
        this.mlist.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchiewHolder {
        val binding = LayoutRecycleviewSmallBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchiewHolder(binding)        }

    override fun onBindViewHolder(holder: SearchiewHolder, position: Int) {
        val searchPlant = mlist[position]
        holder.bind(searchPlant)    }

    override fun getItemCount(): Int = mlist.size

    inner class SearchiewHolder(private val binding: LayoutRecycleviewSmallBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(plantType: PlantTypeModel){
            binding.apply {
                namaPenyakit.text = plantType.name

                Glide.with(itemView.context)
                        .load(plantType.img)
                        .into(binding.gambarPenyakit)

                itemView.setOnClickListener {
                    val i = Intent(itemView.context, ImageActivity::class.java)
                    i.putExtra(ImageActivity.EXTRAJENIS,plantType.name)
                    itemView.context.startActivity(i)

                }

            }


        }
    }
}
