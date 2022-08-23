package com.salihakca2.coinmergen.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "https://api.coinpaprika.com/"

        fun getCoinsDao(): CoinsDao{
            return RetrofitClient.getClient(BASE_URL).create(CoinsDao::class.java)
        }


    }
}