package com.codechallenge.loweather.ui.searchresult

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.codechallenge.loweather.R
import com.codechallenge.loweather.databinding.ListItemForecastBinding
import com.codechallenge.loweather.model.ItemWeather
import com.codechallenge.loweather.toFahrenheit
import com.codechallenge.loweather.ui.details.WeatherDetailsFragment
import kotlin.math.roundToInt


class ForecastRecyclerViewAdapter(
        var items: List<ItemWeather>,
        private val context: Context
) : RecyclerView.Adapter<ForecastRecyclerViewAdapter.ViewHolder>()  {

    inner class ViewHolder(val binding: ListItemForecastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemWeather) {
            with(binding) {
                tempDescription.text = item.weather[0].main
                tempValue.text = item.main.temp.toFahrenheit().roundToInt().toString()
                binding.mainParent.setOnClickListener {
                    val weatherDetailsFragment = WeatherDetailsFragment()
                    weatherDetailsFragment.itemWeather = item

                    (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.container, weatherDetailsFragment).addToBackStack(null).commit()

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ListItemForecastBinding.inflate(inflater, parent, false);

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

}