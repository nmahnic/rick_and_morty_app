package com.nicomahnic.characterspaginglist.di

import com.nicomahnic.characterspaginglist.CharactersPagingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object CharactersPagingListModules {
    val modules = module {
        viewModelOf(::CharactersPagingListViewModel)
    }
}