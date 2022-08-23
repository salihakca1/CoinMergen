package com.salihakca2.coinmergen.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.salihakca2.coinmergen.R
import com.salihakca2.coinmergen.data.entity.CoinModel
import com.salihakca2.coinmergen.databinding.CardDesignBinding
import com.salihakca2.coinmergen.ui.fragment.MainFragmentDirections

class CoinAdapter(var mContext: Context, var coinsList: List<CoinModel>):
    RecyclerView.Adapter<CoinAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design: CardDesignBinding): RecyclerView.ViewHolder(design.root){
        var design: CardDesignBinding
        init {
            this.design = design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val layoutInflater = LayoutInflater.from(mContext)

        val design: CardDesignBinding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val coin = coinsList.get(position)

        val t = holder.design

        t.coinObject = coin

        t.designCardView.setOnClickListener {
            val transition = MainFragmentDirections.actionMainFragment2ToDetailFragment(coin = coin)
            Navigation.findNavController(it).navigate(transition)

        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }
}