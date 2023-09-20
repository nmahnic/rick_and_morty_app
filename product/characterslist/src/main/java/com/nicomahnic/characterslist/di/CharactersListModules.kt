package com.nicomahnic.characterslist.di

import com.nicomahnic.characterslist.CharactersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object CharactersListModules {
    val modules = module {
        viewModelOf(::CharactersListViewModel)
    }
}