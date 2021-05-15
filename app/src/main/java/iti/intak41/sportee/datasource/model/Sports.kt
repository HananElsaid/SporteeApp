package iti.intak41.sportee.datasource.model

import com.google.gson.annotations.SerializedName

data class Sports (

	@SerializedName("idSport") val idSport : Int,
	@SerializedName("strSport") val strSport : String,
	@SerializedName("strFormat") val strFormat : String,
	@SerializedName("strSportThumb") val strSportThumb : String,
	@SerializedName("strSportThumbGreen") val strSportThumbGreen : String,
	@SerializedName("strSportDescription") val strSportDescription : String
)

