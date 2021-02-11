package com.codechallenge.loweather.di

import com.codechallenge.loweather.api.WeatherRepository
import com.codechallenge.loweather.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun providesRepository(
        movieRepositoryImpl: WeatherRepositoryImpl
    ) : WeatherRepository

}