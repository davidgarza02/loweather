package com.codechallenge.loweather.repository;

import com.codechallenge.loweather.api.API_KEY
import com.codechallenge.loweather.api.WeatherEndpoints;
import com.codechallenge.loweather.api.WeatherRepository
import com.codechallenge.loweather.model.ForecastWeather
import retrofit2.Call

import javax.inject.Inject;

class WeatherRepositoryImpl @Inject constructor(
    private val weatherEndpoints: WeatherEndpoints
) : WeatherRepository {

    override fun getForecast(cityName: String): Call<ForecastWeather> {
        return weatherEndpoints.forecastDaysWeather(cityName, API_KEY)
    }

}
