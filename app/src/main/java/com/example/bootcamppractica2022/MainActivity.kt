package com.example.bootcamppractica2022

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bootcamppractica2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BootCampPractica2022)
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        Glide.with(this).load(R.drawable.ic_apple).apply(RequestOptions.circleCropTransform()).into(binding.imgIcAppleLogin)
        Glide.with(this).load(R.drawable.ic_facebook).apply(RequestOptions.circleCropTransform()).into(binding.imgIcFacebookLogin)
        Glide.with(this).load(R.drawable.ic_google).apply(RequestOptions.circleCropTransform()).into(binding.imgIcGoogleLogin)
    }

    override fun onResume() {
        super.onResume()

        binding.txtRegistroLogin.setOnClickListener(View.OnClickListener { toRegister() })
        binding.txtInvitadoLogin.setOnClickListener(View.OnClickListener { toMovies() })
    }

    private fun toRegister() {
        val intent = Intent(this, RegistrationActiviyy::class.java)
        startActivity(intent)
    }

    private fun toMovies() {
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }
}