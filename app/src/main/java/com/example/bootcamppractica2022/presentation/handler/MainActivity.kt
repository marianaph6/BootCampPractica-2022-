package com.example.bootcamppractica2022.presentation.handler

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bootcamppractica2022.databinding.ActivityMainBinding
import com.example.bootcamppractica2022.presentation.navigation.NavigationActivity


class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(com.example.bootcamppractica2022.R.style.Theme_BootCampPractica2022)
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        Glide.with(this).load(com.example.bootcamppractica2022.R.drawable.ic_apple).apply(RequestOptions.circleCropTransform()).into(binding.imgIcAppleLogin)
        Glide.with(this).load(com.example.bootcamppractica2022.R.drawable.ic_facebook).apply(RequestOptions.circleCropTransform()).into(binding.imgIcFacebookLogin)
        Glide.with(this).load(com.example.bootcamppractica2022.R.drawable.ic_google).apply(RequestOptions.circleCropTransform()).into(binding.imgIcGoogleLogin)
    }

    override fun onResume() {
        super.onResume()

        binding.txtRegistroLogin.setOnClickListener(View.OnClickListener { toRegister() })
        binding.txtInvitadoLogin.setOnClickListener(View.OnClickListener { toMovies() })
    }

    private fun toRegister() {


    }

    private fun toMovies() {
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}