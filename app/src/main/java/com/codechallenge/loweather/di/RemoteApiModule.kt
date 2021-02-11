package com.codechallenge.loweather.di

import com.codechallenge.loweather.api.BASE_URL
import com.codechallenge.loweather.api.WeatherEndpoints
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RemoteApiModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun providesWeatherEndpoints() : WeatherEndpoints {
        return providesRetrofit().create(WeatherEndpoints::class.java)
    }
}