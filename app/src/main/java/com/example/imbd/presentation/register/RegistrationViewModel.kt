package com.example.imbd.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imbd.R
import com.example.imbd.domain.useCase.EmailValidatorUseCase
import com.example.imbd.domain.useCase.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    //UsesCase
    private val emailValidatorUseCase: EmailValidatorUseCase

) :ViewModel(){

    private val _uiState= MutableStateFlow(UserInfoState())
    internal val uiState: StateFlow<UserInfoState> = _uiState


    internal fun onEmailSyntax(email: String){
        viewModelScope.launch {
            val result= emailValidatorUseCase(email)
            _uiState.value= UserInfoState(
                isEmailCorrect = result.success ,
                emailError = if(result.correctEmail.not()) R.string.email_error_sintax else null,
                //emptyFileError = if(result.correctEmail.not()) "The email field cannot be empty" else null,
            )

        }
    }


}