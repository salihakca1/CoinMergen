package com.salihakca2.coinmergen.data.repo

import androidx.lifecycle.MutableLiveData
import com.salihakca2.coinmergen.data.entity.CoinModel
import com.salihakca2.coinmergen.data.entity.CoinModelDetail
import com.salihakca2.coinmergen.retrofit.CoinsDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CoinsDaoRepository @Inject constructor(var cdao: CoinsDao) {

    var coinsList: MutableLiveData<List<CoinModel>>
    init {
        coinsList = MutableLiveData()
    }

    fun getCoins(): MutableLiveData<List<CoinModel>> {
        return coinsList
    }

    fun allCoinById(coinId: String, liveData: MutableLiveData<CoinModelDetail>){
        cdao.getCoinById(coinId).enqueue(object : Callback<CoinModelDetail> {
            override fun onResponse(
                call: Call<CoinModelDetail>,
                response: Response<CoinModelDetail>
            ) {

                liveData.value = response.body()
            }

            override fun onFailure(call: Call<CoinModelDetail>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
    fun allCoin(){
        cdao.allCoin().enqueue(object : Callback<List<CoinModel>> {
            override fun onResponse(
                call: Call<List<CoinModel>>,
                response: Response<List<CoinModel>>
            ) {

                val list = response.body()
                coinsList.value = list!!

            }

            override fun onFailure(call: Call<List<CoinModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}