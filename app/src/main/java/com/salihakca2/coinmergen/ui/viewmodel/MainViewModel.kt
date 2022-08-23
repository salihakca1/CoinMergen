package com.salihakca2.coinmergen.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salihakca2.coinmergen.data.entity.CoinModel
import com.salihakca2.coinmergen.data.repo.CoinsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var crepo: CoinsDaoRepository): ViewModel() {

    var coinlist = MutableLiveData<List<CoinModel>>()
    init {
        downloadCoins()
        coinlist = crepo.getCoins()
    }

     fun downloadCoins() {
        crepo.allCoin()
    }

}