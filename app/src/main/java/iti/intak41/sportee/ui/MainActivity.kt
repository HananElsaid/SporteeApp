package iti.intak41.sportee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import iti.intak41.sportee.ui.SportsViewModel

import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   /* @Inject
    lateinit var myClass: SomeClass*/

    private lateinit var sportsViewModel: SportsViewModel
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // Log.i("TAG", myClass.myFun())

        sportsViewModel = ViewModelProvider(this)[SportsViewModel::class.java]
        sportsViewModel.sports.observe(this,{
            Log.i(TAG, "onCreate: ".plus(it))
        })

    }
}

/*@Singleton
class SomeClass
@Inject
constructor() {
    fun myFun(): String {
        return "Hanan"
    }
}*/
