package com.salihakca2.coinmergen.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.coinmergen.R
import com.salihakca2.coinmergen.data.entity.Tag
import com.salihakca2.coinmergen.databinding.TagsDesignBinding

class TagsAdapter(var mContext: Context, var coinsListById: List<Tag>)
    : RecyclerView.Adapter<TagsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design: TagsDesignBinding): RecyclerView.ViewHolder(design.root){
        var design: TagsDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val layoutInflater = LayoutInflater.from(mContext)

        val design: TagsDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.tags_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val coinsListById = coinsListById.get(position)
        val t = holder.design

        t.textViewTags.text = coinsListById.name
    }

    override fun getItemCount(): Int {
        return coinsListById.size
    }
}