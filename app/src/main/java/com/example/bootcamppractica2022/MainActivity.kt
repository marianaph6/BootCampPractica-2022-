package com.example.bootcamppractica2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BootCampPractica2022)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}