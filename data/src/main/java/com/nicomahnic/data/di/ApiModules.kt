package com.nicomahnic.data.di
import com.nicomahnic.data.datasource.network.api.RickMortyService
import com.nicomahnic.product.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiModules {

    val apiModule = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(RickMortyService::class.java)
        }
    }

    val networkModule = module {
        factory { provideOkHttpClient() }
        single { provideRetrofit(get()) }
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_RICK_Y_MORTY)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient().newBuilder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

}