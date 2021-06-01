package com.reza.capstonecap0488.presentation.ui.searchpage.suggestion

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.LayoutRecycleviewSmallBinding
import com.reza.capstonecap0488.domain.SuggestionModel
import com.reza.capstonecap0488.presentation.ui.searchpage.result.ResultActivity

class SuggestionAdapter():RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder>() {

    private var mlist = ArrayList<SuggestionModel>()
    fun setSuggestion(list: List<SuggestionModel>?) {
        if (list == null) return
        this.mlist.clear()
        this.mlist.addAll(list)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SuggestionViewHolder {
        val binding = LayoutRecycleviewSmallBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return SuggestionViewHolder(binding)    }

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        val suggestion = mlist[position]
        holder.bind(suggestion)
    }

    override fun getItemCount(): Int = mlist.size

    inner class SuggestionViewHolder(private val binding: LayoutRecycleviewSmallBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(suggestion: SuggestionModel){
            binding.apply {
                Log.d("cekadapter",suggestion.nama)
                namaPenyakit.text = suggestion.nama

                Glide.with(itemView.context)
                        .load(R.drawable.apel)
                        .into(binding.gambarPenyakit)

                 itemView.setOnClickListener {
                     val i = Intent(itemView.context, ResultActivity::class.java)
                     i.putExtra(ResultActivity.EXTRA,suggestion)
                     itemView.context.startActivity(i)

                 }

            }


        }


    }

}