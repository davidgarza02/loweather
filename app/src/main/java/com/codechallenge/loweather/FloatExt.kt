package com.codechallenge.loweather

fun Float.toFahrenheit(): Double {
    return (this - 273.15) * 9/5 + 32
}