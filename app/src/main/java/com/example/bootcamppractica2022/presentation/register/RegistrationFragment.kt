package com.example.bootcamppractica2022.presentation.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bootcamppractica2022.R
import com.example.bootcamppractica2022.databinding.FragmentRegistrationBinding
import com.example.bootcamppractica2022.presentation.handler.MainActivity


class RegistrationFragment :  Fragment()  {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroy()
        _binding = null
    }
}