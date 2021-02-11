package com.codechallenge.loweather.ui.searchresult

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.codechallenge.loweather.R
import com.codechallenge.loweather.databinding.FragmentSearchBinding
import com.codechallenge.loweather.ui.search.SearchResultsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by activityViewModels()
    private lateinit var binding : FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSearchBinding.bind(view)

        binding.searchButton.setOnClickListener{
            viewModel.searchCity(binding.cityEditText.text.toString())

            dismissKeyboard(it)

            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SearchResultsFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun dismissKeyboard(view : View?) {

        view?.let {
            val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }

    }
}