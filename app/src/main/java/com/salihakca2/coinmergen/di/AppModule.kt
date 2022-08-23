package com.salihakca2.coinmergen.di

import com.salihakca2.coinmergen.data.repo.CoinsDaoRepository
import com.salihakca2.coinmergen.retrofit.ApiUtils
import com.salihakca2.coinmergen.retrofit.CoinsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCoinsDaoRepository(cdao: CoinsDao): CoinsDaoRepository {
        return CoinsDaoRepository(cdao)
    }
    @Provides
    @Singleton
    fun provideCoinsDao(): CoinsDao{
        return ApiUtils.getCoinsDao()
    }

}