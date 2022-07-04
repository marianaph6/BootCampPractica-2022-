package com.example.imbd.domain.di

import com.example.imbd.domain.useCase.EmailValidatorUseCase
import com.example.imbd.domain.useCase.EmailValidatorUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun binEmailValidatorUseCaseImpl(
        emailValidatorUseCaseImpl: EmailValidatorUseCaseImpl
    ): EmailValidatorUseCase


}