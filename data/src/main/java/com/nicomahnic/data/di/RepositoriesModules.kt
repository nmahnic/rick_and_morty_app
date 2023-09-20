package com.nicomahnic.data.di

import com.nicomahnic.data.repository.CharactersRepositoryImpl
import com.nicomahnic.domain.repository.CharactersRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object RepositoriesModules {

    val modules = module {
        singleOf(::CharactersRepositoryImpl){ bind<CharactersRepository>() }
    }

}