package iti.intak41.sportee.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import iti.intak41.sportee.datasource.remote.SportsService
import iti.intak41.sportee.utils.MyConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MyConstants.SPOTRS_URL)
            .addConverterFactory(gson)
            .build()
    }

    @Singleton
    @Provides
    fun provideSportsService(retrofit: Retrofit): SportsService {
        return retrofit
            .create(SportsService::class.java)
    }


}