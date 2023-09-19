package com.nicomahnic.domain.di

import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import org.koin.dsl.module

object UseCasesModules {

    val useCases = module {
        single { GetAllCharactersUseCase( get() ) }
    }

}