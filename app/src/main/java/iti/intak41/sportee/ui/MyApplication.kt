package iti.intak41.sportee.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
   /* @Inject
    lateinit var someClass: SomeClass*/
    override fun onCreate() {
        super.onCreate()

    }

}