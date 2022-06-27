package com.example.imbd.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.fragment.app.Fragment
import com.example.imbd.R
import com.example.imbd.databinding.FragmentRegistrationBinding
import com.example.imbd.presentation.handler.MainActivity


class RegistrationFragment :  Fragment()  {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        print("onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        print("onCreateView()")
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        print("onStart()")
        super.onStart()
    }

    override fun onResume() {
        print("onResume()")
        super.onResume()
    }

    override fun onPause() {
        print("onPause()")
        super.onPause()
    }

    override fun onStop() {
        print("onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        print("onDestroy()")
        super.onDestroy()
    }

    override fun onDestroyView() {
        print("onDestroyView()")
        super.onDestroy()
        _binding = null
    }

    private fun print(msg: String){
        Log.d("Activity State ",msg)
    }
}