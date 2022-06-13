package com.example.bootcamppractica2022.presentation.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bootcamppractica2022.R
import com.example.bootcamppractica2022.databinding.ActivityRegistrationBinding
import com.example.bootcamppractica2022.presentation.handler.MainActivity


class RegistrationActivity : AppCompatActivity() {

    private var _binding: ActivityRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityRegistrationBinding.inflate(layoutInflater)
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}