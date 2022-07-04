package com.example.imbd.domain.useCase

import android.util.Patterns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


interface EmailValidatorUseCase{
    suspend operator fun invoke (email: String): ValidatorResult
}

@Singleton
class EmailValidatorUseCaseImpl @Inject constructor(): EmailValidatorUseCase {
    override suspend fun invoke (email: String): ValidatorResult =
        withContext(Dispatchers.Default){
            ValidatorResult(
                correctEmail= Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNullOrEmpty()
            )
        }
}
data class ValidatorResult (val correctEmail: Boolean)

val ValidatorResult.success get() = correctEmail

