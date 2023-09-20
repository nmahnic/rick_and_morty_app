package com.nicomahnic.charactersdetails.di

import com.nicomahnic.charactersdetails.CharacterDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object CharacterDetailsModules {
    val modules = module {
        viewModelOf(::CharacterDetailsViewModel)
    }
}