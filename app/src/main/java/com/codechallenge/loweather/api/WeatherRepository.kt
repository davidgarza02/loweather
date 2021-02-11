package com.codechallenge.loweather.api

import com.codechallenge.loweather.model.ForecastWeather
import retrofit2.Call

interface WeatherRepository {

    fun getForecast(
        cityName : String
    ) : Call<ForecastWeather>

}