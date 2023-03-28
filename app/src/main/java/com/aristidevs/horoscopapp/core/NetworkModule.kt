package com.aristidevs.horoscopapp.core

import com.aristidevs.horoscopapp.data.network.HoroscopeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://aztro.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideHoroscopeApi(retrofit: Retrofit):HoroscopeApi{
        return retrofit.create(HoroscopeApi::class.java)
    }

}