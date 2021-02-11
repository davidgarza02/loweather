package com.codechallenge.loweather.model

import com.google.gson.annotations.SerializedName

data class ForecastWeather(
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("list")
    val weatherItems: List<ItemWeather>
)

data class ItemWeather(
    @SerializedName("main")
    val main: Main,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("description")
    val descriptionDetail: String
)

data class Main(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float
)


data class Weather(
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
)

data class Temp(
    @SerializedName("day")
    val dayTemp: Float,
    @SerializedName("min")
    val minTemp: Float,
    @SerializedName("max")
    val maxTemp: Float,
    @SerializedName("night")
    val nightTemp: Float,
    @SerializedName("eve")
    val eveningTemp: Float,
    @SerializedName("morn")
    val morningTemp: Float

)