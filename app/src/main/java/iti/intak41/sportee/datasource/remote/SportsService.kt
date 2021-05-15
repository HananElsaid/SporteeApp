package iti.intak41.sportee.datasource.remote


import iti.intak41.sportee.datasource.model.SportsResponse
import iti.intak41.sportee.utils.MyConstants
import iti.intak41.sportee.utils.MyConstants.Companion.SPORTS_URI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsService {
    @GET(SPORTS_URI)
    suspend fun getSports(): Response<SportsResponse>
}

