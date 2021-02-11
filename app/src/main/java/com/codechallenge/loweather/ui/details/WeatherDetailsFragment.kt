package com.codechallenge.loweather.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.codechallenge.loweather.R
import com.codechallenge.loweather.databinding.WeatherDetailsFragmentBinding
import com.codechallenge.loweather.model.ItemWeather
import com.codechallenge.loweather.toFahrenheit
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class WeatherDetailsFragment: Fragment(R.layout.weather_details_fragment) {

    private lateinit var binding : WeatherDetailsFragmentBinding

    lateinit var itemWeather: ItemWeather


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = WeatherDetailsFragmentBinding.bind(view)

        binding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
        binding.toolbar.setNavigationOnClickListener { activity?.supportFragmentManager?.popBackStack() }

        setupUi()
    }

    private fun setupUi() {
        binding.currentTemp.text = itemWeather.main.temp.toFahrenheit().roundToInt().toString()
        binding.feelsLike.text = itemWeather.main.feelsLike.toFahrenheit().roundToInt().toString()
        binding.tempDescription.text = itemWeather.weather[0].main
        binding.secondDescription.text = itemWeather.weather[0].description
    }
}