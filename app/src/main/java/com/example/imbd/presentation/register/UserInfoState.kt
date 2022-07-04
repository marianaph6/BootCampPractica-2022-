package com.example.imbd.presentation.register

internal data class UserInfoState(
    val emailError: Int? = null,
    val isEmailCorrect: Boolean =false,
    val lengthPasswordError: Boolean= false,
    val validFullNameError: Boolean= false,
    val emptyFileError: Boolean= false
)