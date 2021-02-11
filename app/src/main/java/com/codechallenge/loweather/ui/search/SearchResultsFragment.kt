package com.codechallenge.loweather.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codechallenge.loweather.R
import com.codechallenge.loweather.databinding.FragmentSearchResultsBinding
import com.codechallenge.loweather.ui.searchresult.ForecastRecyclerViewAdapter
import com.codechallenge.loweather.ui.searchresult.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchResultsFragment : Fragment(R.layout.fragment_search_results) {

    private val viewModel: SearchViewModel by activityViewModels()
    private lateinit var binding : FragmentSearchResultsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSearchResultsBinding.bind(view)

        observeLiveData()

        binding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
        binding.toolbar.setNavigationOnClickListener { activity?.supportFragmentManager?.popBackStack() }
    }

    private fun observeLiveData() {
        viewModel.searchResults.observe(viewLifecycleOwner, {
            binding.resultsRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.resultsRecyclerView.adapter = ForecastRecyclerViewAdapter(it.weather, requireActivity())
        })
    }


}
