package com.codechallenge.loweather.ui.searchresult

import android.app.Application
import android.widget.Toast
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.codechallenge.loweather.api.WeatherRepository
import com.codechallenge.loweather.base.ForecastWeatherUiModel
import com.codechallenge.loweather.model.ForecastWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository,
    @Assisted private val savedStateHandle: SavedStateHandle,
    val app: Application
) : AndroidViewModel(app), LifecycleObserver {

    val searchResults = MutableLiveData<ForecastWeatherUiModel>()

    fun searchCity(cityName: String) {
        if (cityName.isNotEmpty() && cityName.length > 3) {
            repository.getForecast(cityName)
                .enqueue(object : Callback<ForecastWeather> {
                override fun onResponse(
                    call: Call<ForecastWeather>, response: Response<ForecastWeather>
                ) {
                    if (response.code() == 200 && response.body() != null) {
                        response.body()?.let {
                            searchResults.postValue(ForecastWeatherUiModel(
                                    it.weatherItems
                            ))
                        }
                    } else {
                        Toast.makeText(app,"Error in service",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ForecastWeather>, t: Throwable) {
                    Toast.makeText(app,"Error in service",Toast.LENGTH_SHORT).show()

                }
            })
        }
    }


}