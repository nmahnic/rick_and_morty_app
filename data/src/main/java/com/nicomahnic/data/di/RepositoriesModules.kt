package com.nicomahnic.data.di

import com.nicomahnic.data.repository.CharactersRepositoryImpl
import com.nicomahnic.domain.repository.CharactersRepository
import org.koin.dsl.module

object RepositoriesModules {

    val useCases = module {
        single { CharactersRepositoryImpl() as CharactersRepository}
    }

}