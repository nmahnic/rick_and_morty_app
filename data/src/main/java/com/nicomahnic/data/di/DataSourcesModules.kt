package com.nicomahnic.data.di

import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.network.CharactersDataSourceImpl
import com.nicomahnic.data.datasource.network.mapper.CharactersMapper
import com.nicomahnic.data.datasource.network.mapper.CharactersMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object DataSourcesModules {

    val modules = module {
        singleOf(::CharactersDataSourceImpl){ bind<CharactersDataSource>() }
        singleOf(::CharactersMapperImpl){ bind<CharactersMapper>() }
    }

}