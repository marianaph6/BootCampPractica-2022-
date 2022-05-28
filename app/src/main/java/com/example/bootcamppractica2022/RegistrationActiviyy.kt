package com.example.bootcamppractica2022

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bootcamppractica2022.databinding.ActivityRegistrationBinding


class RegistrationActiviyy : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.toolBarRegistration.setNavigationIcon(R.drawable.ic_arrow_back_24)

        binding.toolBarRegistration.setNavigationOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    MainActivity::class.java
                )
            )
        })
    }
}