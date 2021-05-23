package iti.intak41.sportee.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import iti.intak41.sportee.datasource.model.Sports
import iti.intak41.sportee.datasource.repo.SportsListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(private val sportsListRepo: SportsListRepo) :
    ViewModel() {


    var sports = MutableLiveData<List<Sports>>()
    val TAG= "SportsViewModel"
    init {
        getSportsList()
    }

    fun getSportsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val sportsList = sportsListRepo.getSportsList()
            Log.i(TAG, "getSportsList: ".plus(sportsList))
            if (sportsList.isSuccessful) {
                val body = sportsList.body()?.sports
                withContext(Dispatchers.Main) {
                    sports.postValue( body)
                    Log.i(TAG, "getSportsList: ".plus(body?.get(0)))
                }
            }

        }
    }
}