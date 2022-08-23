package com.salihakca2.coinmergen.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.coinmergen.R
import com.salihakca2.coinmergen.data.entity.Team
import com.salihakca2.coinmergen.databinding.MembersDesignBinding

class MembersAdapter(var mContext: Context, var coinsListById: List<Team>)
    : RecyclerView.Adapter<MembersAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design: MembersDesignBinding): RecyclerView.ViewHolder(design.root){
        var design: MembersDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val layoutInflater = LayoutInflater.from(mContext)

        val design: MembersDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.members_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val coinDetailMembers = coinsListById.get(position)

        val t = holder.design

        t.textViewMemberName.text = coinDetailMembers.name
        t.textViewMemberJob.text = coinDetailMembers.position
    }

    override fun getItemCount(): Int {
        return coinsListById.size
    }

}