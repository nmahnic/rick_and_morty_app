package com.nicomahnic.data.di

import com.nicomahnic.data.repository.CharactersRepositoryImpl
import org.koin.dsl.module

object RepositoriesModules {

    val useCases = module {
        single { CharactersRepositoryImpl( get() ) }
    }

}