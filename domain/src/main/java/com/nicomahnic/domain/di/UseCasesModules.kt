package com.nicomahnic.domain.di

import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import com.nicomahnic.domain.usecases.GetAllPagedCharactersUseCase
import com.nicomahnic.domain.usecases.GetCharacterByIdUseCase
import com.nicomahnic.domain.usecases.SearchCharactersUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object UseCasesModules {

    val modules = module {
        singleOf(::GetAllCharactersUseCase)
        singleOf(::GetCharacterByIdUseCase)
        singleOf(::GetAllPagedCharactersUseCase)
        singleOf(::SearchCharactersUseCase)
    }

}