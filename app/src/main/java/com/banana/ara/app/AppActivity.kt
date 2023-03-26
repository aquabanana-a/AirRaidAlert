package com.banana.ara.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banana.ara.R

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}