package iti.intak41.sportee.datasource.remote

import iti.intak41.sportee.utils.MyConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SportsAPIClient {

    fun getSports(): SportsService {

        return Retrofit.Builder().baseUrl(MyConstants.SPOTRS_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(SportsService::class.java)
    }


}