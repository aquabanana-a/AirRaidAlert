package com.banana.ara.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banana.ara.R
import com.banana.ara.api.AirAlertApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val araService = AirAlertApiService()

        araService.getStates()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                val b = 10
            }
            .doOnComplete {
                val a = 10
            }
            .subscribe {
                val a = it
                val b = 10
            }
    }
}