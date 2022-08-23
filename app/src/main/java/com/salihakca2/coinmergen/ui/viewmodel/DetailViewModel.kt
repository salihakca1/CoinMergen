package com.salihakca2.coinmergen.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.coinmergen.data.entity.CoinModelDetail
import com.salihakca2.coinmergen.data.repo.CoinsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var crepo: CoinsDaoRepository): ViewModel(){
    var coinListById: MutableLiveData<CoinModelDetail>
    init {
        coinListById = MutableLiveData()
    }

    fun getObserverLiveData(): MutableLiveData<CoinModelDetail> {
        return coinListById
    }

    fun loadCoinById(coinId: String){
        crepo.allCoinById(coinId, coinListById)
    }

}