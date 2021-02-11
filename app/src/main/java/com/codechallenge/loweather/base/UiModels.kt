package com.codechallenge.loweather.base

import com.codechallenge.loweather.model.ItemWeather

sealed class SearchUi

data class ForecastWeatherUiModel(
    val weather: List<ItemWeather>
) : SearchUi()
