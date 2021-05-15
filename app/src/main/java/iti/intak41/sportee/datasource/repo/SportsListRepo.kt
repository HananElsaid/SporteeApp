package iti.intak41.sportee.datasource.repo


import iti.intak41.sportee.datasource.model.SportsResponse
import iti.intak41.sportee.datasource.remote.SportsAPIClient
import iti.intak41.sportee.datasource.remote.SportsService
import retrofit2.Response

class SportsListRepo(var sportsServie: SportsService) {
    suspend fun getSportsList(): Response<SportsResponse> {
      /*  val response = sportsServie.getSports()
        if (response.isSuccessful){
            return MyResult.success(response.body())
        }
        else*/  return  sportsServie.getSports()


    }
}