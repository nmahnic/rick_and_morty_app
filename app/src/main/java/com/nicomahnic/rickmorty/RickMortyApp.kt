package com.nicomahnic.rickmorty

import android.app.Application
import com.nicomahnic.characterslist.di.CharactersListModules
import com.nicomahnic.data.di.ApiModules
import com.nicomahnic.data.di.RepositoriesModules
import com.nicomahnic.domain.di.UseCasesModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickMortyApp)
            modules(listOf(
                CharactersListModules.useCases,
                UseCasesModules.useCases,
                RepositoriesModules.useCases,
                ApiModules.apiModule,
                ApiModules.networkModule
            ))
        }
    }
}