package com.salihakca2.coinmergen.retrofit

import com.salihakca2.coinmergen.data.entity.CoinModel
import com.salihakca2.coinmergen.data.entity.CoinModelDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinsDao {
    @GET("v1/coins")
    fun allCoin(): Call<List<CoinModel>>

    @GET("v1/coins/{coinId}")
    fun getCoinById(@Path("coinId") coinId: String): Call<CoinModelDetail>

}