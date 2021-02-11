package com.codechallenge.loweather.api

import com.codechallenge.loweather.model.ForecastWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherEndpoints {

    @GET("forecast")
    fun forecastDaysWeather(
        @Query("q") cityName: String,
        @Query("APPID") id: String
    ): Call<ForecastWeather>
}