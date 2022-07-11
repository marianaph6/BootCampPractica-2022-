package com.example.imbd.presentation.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.imbd.databinding.FragmentRegistrationBinding
import com.example.imbd.presentation.handler.MainViewModel
import kotlinx.coroutines.launch


class RegistrationFragment :  Fragment()  {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    //private val registrationViewModel: RegistrationViewModel by viewModels()

/*    private val sharedViewModel by lazy {
        activity?.let {
            ViewModelProvider(it)[MainViewModel::class.java]
        }
    }*/

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initObservers()

    }

/*
    private fun initObservers() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED){
                registrationViewModel.uiState.collect{ uiState->
                    with(binding){
                        val error= handlerError(uiState.emailError)
                        tieEmailRegistration.error= error?.let(this@RegistrationFragment::getString)
                        if (uiState.isEmailCorrect){
                            registrationViewModel.onEmailSyntax(binding.tieEmailRegistration.toString())
                        }

                    }

                }
            }
        }
    }
*/

    private fun handlerError(emailError: Int?):  Int? = emailError

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
        //_binding = null
    }

    private fun print(msg: String){
        Log.d("Activity State ",msg)
    }
}