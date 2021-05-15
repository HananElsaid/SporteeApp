package iti.intak41.sportee.datasource.model

import com.google.gson.annotations.SerializedName

data class SportsResponse (

	@SerializedName("sports") val sports : List<Sports>
)